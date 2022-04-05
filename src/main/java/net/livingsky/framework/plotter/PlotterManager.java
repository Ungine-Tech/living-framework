package net.livingsky.framework.plotter;

/**
 * @author mikoto
 * @date 2022/4/4 23:45
 */
public interface PlotterManager {
    /**
     * Register a plotter.
     *
     * @param plotterName The name of the plotter.
     * @param plotter     The plotter object.
     */
    void registerPlotter(String plotterName, Plotter plotter);

    /**
     * Get the plotter.
     *
     * @param plotterName The plotter's name.
     * @return The plotter object.
     */
    Plotter getPlotter(String plotterName);
}
