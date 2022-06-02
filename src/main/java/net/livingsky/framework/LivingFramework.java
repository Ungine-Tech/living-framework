package net.livingsky.framework;

import net.livingsky.framework.event.LoadClass;
import net.livingsky.framework.plugin.LivingPlugin;

import java.util.logging.Level;

/**
 * @author mikoto
 * @date 2022/4/3 20:58
 */
public class LivingFramework extends LivingPlugin {


    @Override
    public void onEnable() {
        this.getLogger().log(Level.INFO, "Creating loader instance successful.");
        getServer().getPluginManager().registerEvents(new LoadClass(), this);

    }
}
