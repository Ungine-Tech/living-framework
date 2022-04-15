package net.livingsky.framework.model.scoreboard;

import net.kyori.adventure.text.Component;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @author mikoto
 * @date 2022/4/16 0:01
 */
public class BasicScoreboardFrame extends ScoreboardFrame {
    private static final ArrayList<ScoreboardDatum> SCOREBOARD_DATA = new ArrayList<>();

    public BasicScoreboardFrame(Component title) {
        super(0, title);
    }

    public void setScoreboardDatum(int scoreboardDatumPosition, ScoreboardDatum scoreboardDatum) {
        SCOREBOARD_DATA.add(scoreboardDatumPosition, scoreboardDatum);
    }

    public void setScoreboardDatum(ScoreboardDatum scoreboardDatum) {
        SCOREBOARD_DATA.add(scoreboardDatum);
    }

    public ListIterator<ScoreboardDatum> getScoreboardDataIterator() {
        return SCOREBOARD_DATA.listIterator();
    }
}
