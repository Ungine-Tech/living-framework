package net.livingsky.framework.manager;


import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author mikoto
 * @date 2022/5/6 18:18
 */
public interface InstanceManager<T> {
    /**
     * Save a instance.
     *
     * @param instanceName The name of this instance.
     * @param instance     The instance.
     */
    void saveInstance(String instanceName, T instance);

    /**
     * Create a new instance.
     *
     * @param instanceName  The name of this instance.
     * @param instanceClass The instance class.
     * @throws NoSuchMethodException     An exception.
     * @throws InvocationTargetException An exception.
     * @throws InstantiationException    An exception.
     * @throws IllegalAccessException    An exception.
     */
    void createInstance(String instanceName, Class<?> instanceClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

    /**
     * Get the instances by instance name.
     *
     * @param instanceName The name of this instance.
     * @return Instances.
     */
    Map<Class<?>, Object> getInstances(String instanceName);

    /**
     * Get the instance by class.
     *
     * @param interfaceClass The class.
     * @return Instances.
     */
    Map<String, Object> getInstances(Class<?> interfaceClass);
}
