package net.livingsky.framework.model.scoreboard;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

import static net.livingsky.framework.constant.ComponentConstant.KEY_VALUE_CONNECT_COMPONENT;

/**
 * @author mikoto
 * @date 2022/4/4 22:32
 */
public class ScoreboardDatum {
    private Component datum;

    public ScoreboardDatum(Component text) {
        datum = text;
    }

    public ScoreboardDatum(@NotNull Component key, Component value) {
        datum = key.append(KEY_VALUE_CONNECT_COMPONENT).append(value);
    }

    public Component getDatum() {
        return datum;
    }

    public void setDatum(Component data) {
        this.datum = data;
    }
}
