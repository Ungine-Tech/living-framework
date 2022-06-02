package net.livingsky.framework.loader.impl;

import net.livingsky.framework.loader.Loader;
import net.livingsky.framework.manager.ClassManager;
import net.livingsky.framework.manager.InstanceManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.logging.Level;

/**
 * @author mikoto
 * @date 2022/5/7 12:14
 */
public record ClassLoaderImpl(JavaPlugin javaPlugin) implements Loader {

    /**
     * Scan the class in the package.
     *
     * @param classManager    The class manager.
     * @param instanceManager The instance manager.
     */
    @Override
    public void doLoad(@NotNull ClassManager classManager, InstanceManager<Object> instanceManager) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        while (!classManager.isEmpty()) {
            Map<String, Class<?>> classMap = classManager.getNearestClasses();
            for (Map.Entry<String, Class<?>> entry :
                    classMap.entrySet()) {
                javaPlugin.getLogger().log(Level.INFO, "Load class: " + entry.getKey() + ", " + entry.getValue().getName());
                instanceManager.createInstance(entry.getKey(), entry.getValue());
            }
        }
    }
}
