package net.livingsky.framework.plotter.impl;

import net.livingsky.framework.plotter.Plotter;
import net.livingsky.framework.plotter.PlotterManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mikoto
 * @date 2022/4/4 23:45
 */
public class PlotterManagerImpl implements PlotterManager {
    private static final Map<String, Plotter> PLOTTER_MAP = new ConcurrentHashMap<>();

    /**
     * Register a plotter.
     *
     * @param plotterName The name of the plotter.
     * @param plotter     The plotter object.
     */
    @Override
    public void registerPlotter(String plotterName, Plotter plotter) {
        PLOTTER_MAP.put(plotterName, plotter);
    }

    /**
     * Get the plotter.
     *
     * @param plotterName The plotter's name.
     * @return The plotter object.
     */
    @Override
    public Plotter getPlotter(String plotterName) {
        return PLOTTER_MAP.get(plotterName);
    }
}
