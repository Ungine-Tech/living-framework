package net.livingsky.framework.applet;

import net.livingsky.framework.plotter.Plotter;

/**
 * @author mikoto
 * @date 2022/4/5 0:03
 */
public record AppletResponse(Plotter plotter) {

    public Plotter getPlotter() {
        return plotter;
    }
}
