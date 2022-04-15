package net.livingsky.framework.model;

/**
 * @author mikoto
 * @date 2022/4/4 20:52
 */
public class Scene {
    private final Frame basicFrame;
    private final String sceneName;
    private final int continueTime;
    private final boolean loop;

    public Scene(boolean loop, int continueTime, String sceneName, Frame basicFrame) {
        this.loop = loop;
        this.continueTime = continueTime;
        this.sceneName = sceneName;
        this.basicFrame = basicFrame;
    }

    public boolean isLoop() {
        return loop;
    }

    public int getContinueTime() {
        return continueTime;
    }

    public String getSceneName() {
        return sceneName;
    }

    public Frame getBasicFrame() {
        return basicFrame;
    }
}
