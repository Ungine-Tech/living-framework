package net.livingsky.framework.model.scoreboard;

import net.kyori.adventure.text.Component;
import org.bukkit.scoreboard.Team;

/**
 * @author mikoto
 * @date 2022/4/15 23:15
 */
public abstract class DynamicScoreboardDatum extends ScoreboardDatum {
    private Team team;

    public DynamicScoreboardDatum(String datum) {
        super(datum);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Get a dynamic datum.
     *
     * @return A component object.
     */
    public abstract Component getDynamicDatum();
}
