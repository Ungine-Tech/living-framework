package net.livingsky.framework.manager.impl;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import net.livingsky.framework.manager.InstanceManager;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.util.Map;

/**
 * @author mikoto
 * @date 2022/5/6 18:33
 */
public class InstanceManagerImpl<T> implements InstanceManager<T> {
    private final Table<Class<?>, String, T> TABLE = HashBasedTable.create();

    /**
     * Save a instance.
     *
     * @param instanceName The name of this instance.
     * @param instance     The instance.
     */
    @Override
    public void saveInstance(String instanceName, @NotNull T instance) {
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
    public void createInstance(String instanceName, Class<?> instanceClass) {
        if (instanceName == null) {
            instanceName = "";
        }

        Constructor<?> constructor = instanceClass.getConstructors()[0];

    }

    /**
     * Get the instances by instance name.
     *
     * @param instanceName The name of this instance.
     * @return Instances.
     */
    @Override
    public Map<Class<?>, T> getInstances(String instanceName) {
        return TABLE.column(instanceName);
    }

    /**
     * Get the instance by class.
     *
     * @param interfaceClass The class.
     * @return Instances.
     */
    @Override
    public Map<String, T> getInstances(Class<?> interfaceClass) {
        return TABLE.row(interfaceClass);
    }
}
