package net.livingsky.framework;

import net.livingsky.framework.event.EnablePlugin;
import net.livingsky.framework.event.LoadClass;
import net.livingsky.framework.plugin.LivingPlugin;

/**
 * @author mikoto
 * @date 2022/4/3 20:58
 */
public class LivingFramework extends LivingPlugin {
    @Override
    public void onLoad() {
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new LoadClass(), this);
        getServer().getPluginManager().registerEvents(new EnablePlugin(), this);
    }
}
