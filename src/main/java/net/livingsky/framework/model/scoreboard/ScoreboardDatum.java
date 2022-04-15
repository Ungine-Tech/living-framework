package net.livingsky.framework.model.scoreboard;

/**
 * @author mikoto
 * @date 2022/4/4 22:32
 */
public abstract class ScoreboardDatum {
    private final String datum;

    public ScoreboardDatum(String datum) {
        this.datum = datum;
    }

    public String getDatum() {
        return datum;
    }
}
