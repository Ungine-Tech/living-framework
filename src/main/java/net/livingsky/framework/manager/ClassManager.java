package net.livingsky.framework.manager;

import java.util.Map;

/**
 * @author mikoto
 * @date 2022/5/6 22:28
 */
public interface ClassManager {
    /**
     * Save the class.
     *
     * @param className The name of this class.
     * @param clazz     The class.
     * @param priority  The priority.
     */
    void saveClass(int priority, String className, Class<?> clazz);

    /**
     * Get the nearest class.
     *
     * @return The class.
     */
    Map<String, Class<?>> getNearestClasses();

    /**
     * Test if the table is null.
     *
     * @return A boolean.
     */
    boolean isEmpty();
}
