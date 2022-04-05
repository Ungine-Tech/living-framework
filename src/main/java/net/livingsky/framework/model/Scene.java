package net.livingsky.framework.model;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

/**
 * @author mikoto
 * @date 2022/4/4 20:52
 */
public class Scene {
    private final TimeUnit timeUnit;
    private final int continueTime;
    private final boolean loop;
    private final ArrayList<Frame> frames = new ArrayList<>();

    public Scene(boolean loop, int continueTime, TimeUnit timeUnit) {
        this.loop = loop;
        this.continueTime = continueTime;
        this.timeUnit = timeUnit;
    }

    public boolean isLoop() {
        return loop;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public int getContinueTime() {
        return continueTime;
    }

    public void setFrame(int framePosition, Frame frame) {
        frames.add(framePosition, frame);
    }

    public void setFrame(Frame frame) {
        frames.add(frame.getFramePosition(), frame);
    }

    public Frame getFrame(int framePosition) {
        return frames.get(framePosition);
    }

    public ListIterator<Frame> getFrameIterator() {
        return frames.listIterator();
    }
}
