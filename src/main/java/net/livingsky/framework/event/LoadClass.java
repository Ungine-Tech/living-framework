package net.livingsky.framework.event;

import net.livingsky.framework.plugin.Living;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;

/**
 * @author mikoto
 * @date 2022/5/7 11:16
 */
public class LoadClass implements Listener {
    @EventHandler
    public void load(ServerLoadEvent serverLoadEvent) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        while (!Living.CLASS_MANAGER.isEmpty()) {
            Map<String, Class<?>> classMap = Living.CLASS_MANAGER.getNearestClasses();
            for (Map.Entry<String, Class<?>> entry :
                    classMap.entrySet()) {
                Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("living-framework")).getLogger().log(Level.INFO, "Load class: " + entry.getKey() + ", " + entry.getValue().getName());
                Living.INSTANCE_MANAGER.createInstance(entry.getKey(), entry.getValue());
            }
        }
    }
}
