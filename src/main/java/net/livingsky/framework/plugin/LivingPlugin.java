package net.livingsky.framework.plugin;

import net.livingsky.framework.manager.ClassManager;
import net.livingsky.framework.manager.InstanceManager;
import net.livingsky.framework.scanner.Scanner;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * @author mikoto
 * @date 2022/6/3 2:31
 */
public abstract class LivingPlugin extends JavaPlugin {
    public ClassManager getClassManager() {
        return Living.CLASS_MANAGER;
    }

    public InstanceManager getInstanceManager() {
        return Living.INSTANCE_MANAGER;
    }

    public void scanPackage(@NotNull Scanner scanner, String packageName) {
        scanner.doScan(packageName, Living.CLASS_MANAGER);
    }
}
