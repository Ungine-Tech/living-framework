package net.livingsky.framework.model.scoreboard;

import net.kyori.adventure.text.Component;
import net.livingsky.framework.model.Frame;

/**
 * @author mikoto
 * @date 2022/4/4 21:11
 */
public class ScoreboardFrame extends Frame {
    private Component title;

    public ScoreboardFrame(int framePosition, Component title) {
        super(framePosition);
        this.title = title;
    }

    public Component getTitle() {
        return title;
    }

    public void setTitle(Component title) {
        this.title = title;
    }
}
