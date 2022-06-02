package net.livingsky.framework.event;

import net.livingsky.framework.SimpleFramework;
import net.livingsky.framework.annotation.AutoScan;
import net.livingsky.framework.annotation.LivingPlugin;
import net.livingsky.framework.annotation.ScanPath;
import net.livingsky.framework.scanner.Scanner;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;


/**
 * @author mikoto
 * @date 2022/5/7 2:57
 */
public class PluginScan implements Listener {
    @EventHandler
    public void scan(@NotNull PluginEnableEvent pluginEnableEvent) {
        Class<? extends Plugin> plugin = pluginEnableEvent.getPlugin().getClass();

        Set<String> scanPackage = new HashSet<>();
        for (Annotation annotation :
                plugin.getAnnotations()) {
            if (annotation instanceof LivingPlugin) {
                Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("living-framework")).getLogger().log(Level.INFO, "Loading living plugin: " + ((LivingPlugin) annotation).value());
            } else if (annotation instanceof AutoScan) {
                scanPackage.add(plugin.getPackageName());
            } else if (annotation instanceof ScanPath) {
                scanPackage.add(((ScanPath) annotation).value());
            }
        }

        for (String packageName :
                scanPackage) {
            Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("living-framework")).getLogger().log(Level.INFO, "Scanning package: " + packageName);
            ((Scanner) SimpleFramework.getInstance().getInstanceManager().getInstance(Scanner.class, "ServiceScanner")).doScan(packageName, SimpleFramework.getInstance().getClassManager());
            ((Scanner) SimpleFramework.getInstance().getInstanceManager().getInstance(Scanner.class, "PlotterScanner")).doScan(packageName, SimpleFramework.getInstance().getClassManager());
        }
    }
}
