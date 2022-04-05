package net.livingsky.framework.model.scoreboard;

import net.livingsky.framework.model.Frame;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @author mikoto
 * @date 2022/4/4 21:11
 */
public class ScoreboardFrame extends Frame {
    private static final ArrayList<ScoreboardDatum> scoreboardData = new ArrayList<>();
    private String title;

    public ScoreboardFrame(int framePosition, String title) {
        super(framePosition);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setScoreboardDatum(int scoreboardDatumPosition, ScoreboardDatum scoreboardDatum) {
        scoreboardData.add(scoreboardDatumPosition, scoreboardDatum);
    }

    public void setScoreboardDatum(ScoreboardDatum scoreboardDatum) {
        scoreboardData.add(scoreboardDatum);
    }

    public ListIterator<ScoreboardDatum> getScoreboardDataIterator() {
        return scoreboardData.listIterator();
    }
}
