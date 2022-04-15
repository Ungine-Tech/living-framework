package net.livingsky.framework.applet.impl;

import net.livingsky.framework.applet.AppletResponse;
import net.livingsky.framework.model.Scene;
import net.livingsky.framework.plotter.Plotter;
import net.livingsky.framework.plugin.LivingJavaPlugin;

/**
 * @author mikoto
 * @date 2022/4/15 18:20
 */
public class AppletResponseImpl implements AppletResponse {
    private final LivingJavaPlugin livingJavaPlugin;
    private Plotter plotter;
    private Scene scene;

    public AppletResponseImpl(LivingJavaPlugin livingJavaPlugin) {
        this.livingJavaPlugin = livingJavaPlugin;
    }

    @Override
    public Plotter getPlotter() {
        return plotter;
    }

    @Override
    public void setPlotter(Plotter plotter) {
        this.plotter = plotter;
    }

    @Override
    public void setPlotter(String plotterName) {
        setPlotter(livingJavaPlugin.getPlotterManager().getPlotter(plotterName));
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
