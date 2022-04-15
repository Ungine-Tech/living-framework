package net.livingsky.framework.plotter;

import net.livingsky.framework.model.Frame;
import net.livingsky.framework.model.Scene;
import org.bukkit.entity.Entity;

/**
 * @author mikoto
 * @date 2022/4/4 23:43
 */
public interface Plotter {
    /**
     * The entity need to be plotted.
     *
     * @param entity    The entity.
     * @param frame     The scene.
     * @param sceneName The name of this scene.
     * @throws CloneNotSupportedException Throw this exception when the object is not proper.
     */
    void produce(Entity entity, Frame frame, String sceneName) throws CloneNotSupportedException;

    /**
     * Produce all frame in the scene.
     *
     * @param entity The entity.
     * @param scene  The scene.
     * @throws CloneNotSupportedException Throw this exception when the object is not proper.
     * @throws InterruptedException       An exception.
     */
    void produceAll(Entity entity, Scene scene) throws CloneNotSupportedException, InterruptedException;
}
