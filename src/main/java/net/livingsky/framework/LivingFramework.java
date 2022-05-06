package net.livingsky.framework;

import net.livingsky.framework.annotation.LivingPlugin;
import net.livingsky.framework.manager.InstanceManager;
import net.livingsky.framework.manager.impl.InstanceManagerImpl;
import net.livingsky.framework.plugin.LivingJavaPlugin;
import net.livingsky.framework.scanner.Scanner;

import java.util.logging.Level;

/**
 * @author mikoto
 * @date 2022/4/3 20:58
 */
@LivingPlugin
public class LivingFramework extends LivingJavaPlugin {
    private static final InstanceManager<Scanner> SCANNER_INSTANCE_MANAGER = new InstanceManagerImpl<>();

    @Override
    public void onEnable() {
        this.getLogger().log(Level.INFO, "Start scanner.");
    }
}
