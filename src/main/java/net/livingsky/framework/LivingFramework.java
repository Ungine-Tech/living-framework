package net.livingsky.framework;

import net.livingsky.framework.event.ClassLoad;
import net.livingsky.framework.event.PluginScan;
import net.livingsky.framework.loader.impl.ClassLoaderImpl;
import net.livingsky.framework.scanner.impl.PlotterScannerImpl;
import net.livingsky.framework.scanner.impl.ServiceScannerImpl;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * @author mikoto
 * @date 2022/4/3 20:58
 */
public class LivingFramework extends JavaPlugin {
    @Override
    public void onEnable() {

        SimpleFramework.getInstance().getInstanceManager().saveInstance("ServiceScanner", new ServiceScannerImpl(this));
        SimpleFramework.getInstance().getInstanceManager().saveInstance("PlotterScanner", new PlotterScannerImpl(this));
        this.getLogger().log(Level.INFO, "Creating scanner instance successful.");
        SimpleFramework.getInstance().getInstanceManager().saveInstance("ClassLoader", new ClassLoaderImpl(this));
        this.getLogger().log(Level.INFO, "Creating loader instance successful.");
        getServer().getPluginManager().registerEvents(new ClassLoad(), this);
        getServer().getPluginManager().registerEvents(new PluginScan(), this);

    }
}
