package net.livingsky.framework.applet;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;

/**
 * @author mikoto
 * @date 2022/4/15 18:14
 */
public interface AppletRequest {
    /**
     * Get a player.
     *
     * @return A Player.
     */
    Player getPlayer();

    /**
     * Get a player event.
     *
     * @return A PlayerEvent.
     */
    PlayerEvent getPlayerEvent();
}
