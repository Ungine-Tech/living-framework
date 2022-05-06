package net.livingsky.framework.manager.impl;

import net.livingsky.framework.manager.ClassManager;

import java.util.Map;

/**
 * @author mikoto
 * @date 2022/5/6 22:37
 */
public class ClassManagerImpl implements ClassManager {
    /**
     * Save the class.
     *
     * @param priority  The priority.
     * @param className The name of this class.
     * @param clazz     The class.
     */
    @Override
    public void saveClass(int priority, String className, Class<?> clazz) {

    }

    /**
     * Get the nearest class.
     *
     * @return The class.
     */
    @Override
    public Map.Entry<String, Class<?>> getNearestClass() {
        return null;
    }
}
