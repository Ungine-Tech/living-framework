package net.livingsky.framework.event;

import net.livingsky.framework.annotation.AutoScan;
import net.livingsky.framework.plugin.LivingPlugin;
import net.livingsky.framework.scanner.impl.ServiceScanner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * @author mikoto
 * @date 2022/6/3 3:11
 */
public class EnablePlugin implements Listener {
    @EventHandler
    public void enablePlugin(@NotNull PluginEnableEvent pluginEnableEvent) {
        JavaPlugin plugin = (JavaPlugin) pluginEnableEvent.getPlugin();

        if (plugin instanceof LivingPlugin) {
            if (plugin.getClass().isAnnotationPresent(AutoScan.class)) {
                ((LivingPlugin) plugin).scanPackage(new ServiceScanner(plugin), plugin.getClass().getPackageName());
            }
        }
    }
}
