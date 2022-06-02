package net.livingsky.framework.loader;

import net.livingsky.framework.manager.ClassManager;
import net.livingsky.framework.manager.InstanceManager;

import java.lang.reflect.InvocationTargetException;

/**
 * @author mikoto
 * @date 2022/5/7 12:14
 */
public interface Loader {
    /**
     * Scan the class in the package.
     *
     * @param classManager    The class manager.
     * @param instanceManager The instance manager.
     */
    void doLoad(ClassManager classManager, InstanceManager<Object> instanceManager) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
