package net.livingsky.framework.plugin;

import net.livingsky.framework.applet.AppletManager;
import net.livingsky.framework.applet.impl.AppletManagerImpl;
import net.livingsky.framework.plotter.PlotterManager;
import net.livingsky.framework.plotter.impl.PlotterManagerImpl;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author mikoto
 * @date 2022/4/4 23:55
 */
public abstract class LivingJavaPlugin extends JavaPlugin {
    private final AppletManager APPLET_MANAGER = new AppletManagerImpl(this);
    private final PlotterManager PLOTTER_MANAGER = new PlotterManagerImpl();

    public AppletManager getAppletManager() {
        return APPLET_MANAGER;
    }

    public PlotterManager getPlotterManager() {
        return PLOTTER_MANAGER;
    }
}
