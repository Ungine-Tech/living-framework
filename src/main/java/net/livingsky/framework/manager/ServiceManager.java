package net.livingsky.framework.manager;

import java.util.Map;

/**
 * @author mikoto
 * @date 2022/5/6 18:27
 */
public interface ServiceManager {
    /**
     * Save the service class.
     *
     * @param serviceName The name of the service.
     * @param clazz       The service class.
     */
    void saveServiceClass(String serviceName, Class<?> clazz);

    /**
     * Get the classes.
     *
     * @return The classes.
     */
    Map<String, Class<?>> getServiceClasses();
}
