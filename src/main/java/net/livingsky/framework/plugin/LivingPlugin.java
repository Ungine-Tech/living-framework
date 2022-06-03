package net.livingsky.framework.plugin;

import net.livingsky.framework.manager.ClassManager;
import net.livingsky.framework.manager.InstanceManager;
import net.livingsky.framework.scanner.Scanner;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author mikoto
 * @date 2022/6/3 2:31
 */
public abstract class LivingPlugin extends JavaPlugin {
    private Scanner scanner = null;

    public ClassManager getClassManager() {
        return Living.CLASS_MANAGER;
    }

    public InstanceManager getInstanceManager() {
        return Living.INSTANCE_MANAGER;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
