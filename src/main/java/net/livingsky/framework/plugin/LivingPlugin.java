package net.livingsky.framework.plugin;

import net.livingsky.framework.manager.ClassManager;
import net.livingsky.framework.manager.InstanceManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author mikoto
 * @date 2022/6/3 2:31
 */
public class LivingPlugin extends JavaPlugin {
    public ClassManager getClassManager() {
        return Living.CLASS_MANAGER;
    }

    public InstanceManager getInstanceManager() {
        return Living.INSTANCE_MANAGER;
    }
}
