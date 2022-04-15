package net.livingsky.framework.plotter.impl;

import net.livingsky.framework.model.Frame;
import net.livingsky.framework.model.Scene;
import net.livingsky.framework.model.scoreboard.*;
import net.livingsky.framework.plotter.Plotter;
import net.livingsky.framework.plugin.LivingJavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author mikoto
 * @date 2022/4/9 3:33
 */
public class ScoreboardPlotterImpl implements Plotter {
    private final LivingJavaPlugin livingJavaPlugin;

    public ScoreboardPlotterImpl(LivingJavaPlugin livingJavaPlugin) {
        this.livingJavaPlugin = livingJavaPlugin;
    }

    /**
     * The entity need to be plotted.
     *
     * @param entity    The entity.(Player)
     * @param frame     The frame.(ScoreboardFrame)
     * @param sceneName The name of this scene.
     * @throws CloneNotSupportedException Throw this exception when the object is not proper.
     */
    @Override
    public void produce(Entity entity, Frame frame, String sceneName) throws CloneNotSupportedException {
        if (entity instanceof Player && frame instanceof ScoreboardFrame) {
            Scoreboard scoreboard = ((Player) entity).getScoreboard();
            Objective objective = scoreboard.getObjective(sceneName);
            assert objective != null;
            objective.displayName(((ScoreboardFrame) frame).getTitle());
            ((Player) entity).setScoreboard(scoreboard);
        } else {
            throw new CloneNotSupportedException("ScoreboardPlotter only supported Player and ScoreboardScene");
        }
    }

    /**
     * Produce all frame in the scene.
     *
     * @param entity The entity.(Player)
     * @param scene  The scene.(ScoreboardScene)
     * @throws CloneNotSupportedException Throw this exception when the object is not proper.
     */
    @Override
    public void produceAll(Entity entity, Scene scene) throws CloneNotSupportedException {
        if (entity instanceof Player && scene instanceof ScoreboardScene) {
            Bukkit.getScheduler().runTaskTimer(livingJavaPlugin, (bukkitTask) -> {
                Iterator<ScoreboardFrame> scoreboardFrameIterator = ((ScoreboardScene) scene).getScoreboardFrameIterator();
                if (scoreboardFrameIterator.hasNext()) {
                    ScoreboardFrame scoreboardFrame = scoreboardFrameIterator.next();
                    if (scoreboardFrame instanceof BasicScoreboardFrame) {
                        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
                        Objective objective = scoreboard.registerNewObjective(scene.getSceneName(), "dummy", scoreboardFrame.getTitle());
                        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                        ((Player) entity).setScoreboard(scoreboard);
                        ListIterator<ScoreboardDatum> scoreboardDatumListIterator = ((BasicScoreboardFrame) scoreboardFrame).getScoreboardDataIterator();
                        int score = 0;
                        while (scoreboardDatumListIterator.hasNext()) {
                            ScoreboardDatum scoreboardDatum = scoreboardDatumListIterator.next();
                            if (scoreboardDatum instanceof StaticScoreboardDatum) {
                                objective.getScore(scoreboardDatum.getDatum()).setScore(score - 1);
                            } else if (scoreboardDatum instanceof DynamicScoreboardDatum) {
                                ((DynamicScoreboardDatum) scoreboardDatum).setTeam(scoreboard.registerNewTeam(scoreboardDatum.getDatum()));
                                objective.getScore(scoreboardDatum.getDatum()).setScore(score - 1);
                                ((DynamicScoreboardDatum) scoreboardDatum).getTeam().addEntry(scoreboardDatum.getDatum());
                            }
                        }
                    }
                }

                while (scoreboardFrameIterator.hasNext()) {
                    ScoreboardFrame scoreboardFrame = scoreboardFrameIterator.next();
                    try {
                        produce(entity, scoreboardFrame, scene.getSceneName());
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                }

                if (!scene.isLoop() || !((Player) entity).isOnline()) {
                    Frame frame = ((ScoreboardScene) scene).getScoreboardFrame(0);
                    if (frame instanceof BasicScoreboardFrame) {
                        ListIterator<ScoreboardDatum> scoreboardDatumListIterator = ((BasicScoreboardFrame) frame).getScoreboardDataIterator();
                        while (scoreboardDatumListIterator.hasNext()) {
                            ScoreboardDatum scoreboardDatum = scoreboardDatumListIterator.next();
                            if (scoreboardDatum instanceof DynamicScoreboardDatum) {
                                ((DynamicScoreboardDatum) scoreboardDatum).getTeam().removeEntry(scoreboardDatum.getDatum());
                                ((DynamicScoreboardDatum) scoreboardDatum).getTeam().unregister();
                            }
                        }
                    }
                    bukkitTask.cancel();
                }
            }, 0L, scene.getContinueTime());
        } else {
            throw new CloneNotSupportedException("ScoreboardPlotter only supported Player and ScoreboardScene");
        }
    }
}
