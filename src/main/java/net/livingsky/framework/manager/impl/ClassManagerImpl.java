package net.livingsky.framework.manager.impl;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import net.livingsky.framework.manager.ClassManager;

import java.util.Arrays;
import java.util.Map;

/**
 * @author mikoto
 * @date 2022/5/6 22:37
 */
public class ClassManagerImpl implements ClassManager {
    private final Table<Integer, String, Class<?>> TABLE = HashBasedTable.create();

    /**
     * Save the class.
     *
     * @param priority  The priority.
     * @param className The name of this class.
     * @param clazz     The class.
     */
    @Override
    public void saveClass(int priority, String className, Class<?> clazz) {
        TABLE.put(priority, className, clazz);
    }

    /**
     * Get the nearest class.
     *
     * @return The class.
     */
    @Override
    public Map<String, Class<?>> getNearestClasses() {
        Integer[] integers = TABLE.rowKeySet().toArray(new Integer[0]);
        Arrays.sort(integers);
        Map<String, Class<?>> classMap = Map.copyOf(TABLE.row(integers[0]));
        for (Map.Entry<String, Class<?>> mapEntry :
                classMap.entrySet()) {
            TABLE.remove(integers[0], mapEntry.getKey());
        }
        return classMap;
    }

    /**
     * Test if the table is null.
     *
     * @return A boolean.
     */
    @Override
    public boolean isEmpty() {
        return TABLE.isEmpty();
    }
}
