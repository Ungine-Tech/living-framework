package net.livingsky.framework;

import net.livingsky.framework.manager.InstanceManager;
import net.livingsky.framework.manager.impl.InstanceManagerImpl;
import net.livingsky.framework.plugin.LivingJavaPlugin;

import java.util.logging.Level;

/**
 * @author mikoto
 * @date 2022/4/3 20:58
 */
public class LivingFramework extends LivingJavaPlugin {
    private static final InstanceManager<Object> INSTANCE_MANAGER = new InstanceManagerImpl();

    @Override
    public void onEnable() {
        this.getLogger().log(Level.INFO, "Creating scanner instance.");
    }
}
