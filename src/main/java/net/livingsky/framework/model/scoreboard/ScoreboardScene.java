package net.livingsky.framework.model.scoreboard;

import net.livingsky.framework.model.Scene;

import java.util.concurrent.TimeUnit;

/**
 * @author mikoto
 * @date 2022/4/4 21:12
 */
public class ScoreboardScene extends Scene {
    public ScoreboardScene(boolean loop, int continueTime, TimeUnit timeUnit) {
        super(loop, continueTime, timeUnit);
    }
}
