package net.livingsky.framework.model.scoreboard;

import net.livingsky.framework.model.Frame;
import net.livingsky.framework.model.Scene;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @author mikoto
 * @date 2022/4/4 21:12
 */
public class ScoreboardScene extends Scene {
    private final ArrayList<ScoreboardFrame> scoreboardFrames = new ArrayList<>();

    public ScoreboardScene(boolean loop, int continueTime, String sceneName, ScoreboardFrame basicFrame) {
        super(loop, continueTime, sceneName, basicFrame);
        scoreboardFrames.add(0, basicFrame);
    }


    public void setScoreboardFrame(int framePosition, ScoreboardFrame frame) {
        scoreboardFrames.add(framePosition, frame);
    }

    public void setScoreboardFrame(ScoreboardFrame frame) {
        scoreboardFrames.add(frame.getFramePosition(), frame);
    }

    public Frame getScoreboardFrame(int framePosition) {
        return scoreboardFrames.get(framePosition);
    }

    public ListIterator<ScoreboardFrame> getScoreboardFrameIterator() {
        return scoreboardFrames.listIterator();
    }
}
