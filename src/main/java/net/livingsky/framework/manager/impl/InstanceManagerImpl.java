package net.livingsky.framework.manager.impl;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import net.livingsky.framework.annotation.Wired;
import net.livingsky.framework.manager.InstanceManager;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static net.livingsky.framework.annotation.First.CLASS;

/**
 * @author mikoto
 * @date 2022/5/6 18:33
 */
public class InstanceManagerImpl implements InstanceManager<Object> {
    private final Table<Class<?>, String, Object> TABLE = HashBasedTable.create();

    /**
     * Save a instance.
     *
     * @param instanceName The name of this instance.
     * @param instance     The instance.
     */
    @Override
    public void saveInstance(String instanceName, @NotNull Object instance) {
        if (instanceName == null) {
            instanceName = "";
        }

        for (Class<?> interfaceClass :
                instance.getClass().getInterfaces()) {
            TABLE.put(interfaceClass, instanceName, instance);
        }
    }

    /**
     * Create a new instance.
     *
     * @param instanceName  The name of this instance.
     * @param instanceClass The instance class.
     */
    @Override
    public void createInstance(String instanceName, Class<?> instanceClass) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        if (instanceName == null) {
            instanceName = "";
        }

        ConcurrentHashMap<Class<?>, Object> wiredInstanceMap = new ConcurrentHashMap<>(16);

        // Scan field and get wired instance.
        for (Field field :
                instanceClass.getDeclaredFields()) {
            for (Wired annotation :
                    field.getAnnotationsByType(Wired.class)) {
                Object instance;

                if (annotation.first().equals(CLASS)) {
                    Map<String, Object> instances = getInstances(field.getType());
                    instance = instances.get(annotation.value());
                } else {
                    Map<Class<?>, Object> instances = getInstances(annotation.value());
                    instance = instances.get(field.getType());
                }

                if (!annotation.nullable() && instance == null) {
                    throw new NullPointerException();
                }

                wiredInstanceMap.put(field.getType(), instance);
            }
        }

        // Scan constructor and new instance.
        for (Constructor<?> constructor :
                instanceClass.getConstructors()) {
            boolean flag = true;
            for (Class<?> clazz :
                    constructor.getParameterTypes()) {
                if (!wiredInstanceMap.containsKey(clazz)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                saveInstance(instanceName, constructor.newInstance(wiredInstanceMap.values().toArray()));
                break;
            }
        }
    }

    /**
     * Get the instances by instance name.
     *
     * @param instanceName The name of this instance.
     * @return Instances.
     */
    @Override
    public Map<Class<?>, Object> getInstances(String instanceName) {
        return TABLE.column(instanceName);
    }

    /**
     * Get the instance by class.
     *
     * @param interfaceClass The class.
     * @return Instances.
     */
    @Override
    public Map<String, Object> getInstances(Class<?> interfaceClass) {
        return TABLE.row(interfaceClass);
    }

    /**
     * Get an instance.
     *
     * @param interfaceClass The class of this interface.
     * @param instanceName   The name of this instance.
     * @return The instance
     */
    @Override
    public Object getInstance(Class<?> interfaceClass, String instanceName) {
        return TABLE.get(interfaceClass, instanceName);
    }
}
