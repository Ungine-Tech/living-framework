package net.livingsky.framework.applet;

import net.livingsky.framework.model.Scene;
import net.livingsky.framework.plotter.Plotter;

/**
 * @author mikoto
 * @date 2022/4/15 18:15
 */
public interface AppletResponse {
    /**
     * Get the plotter.
     *
     * @return The plotter object.
     */
    Plotter getPlotter();

    /**
     * Set a plotter by plotter object.
     *
     * @param plotter A plotter object.
     */
    void setPlotter(Plotter plotter);

    /**
     * Set a plotter by plotter name.
     *
     * @param plotterName A plotter name.
     */
    void setPlotter(String plotterName);

    /**
     * Get the scene.
     *
     * @return The scene object.
     */
    Scene getScene();

    /**
     * Set a scene.
     *
     * @param scene A scene object.
     */
    void setScene(Scene scene);
}
