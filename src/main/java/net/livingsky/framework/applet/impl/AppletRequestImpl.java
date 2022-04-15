package net.livingsky.framework.applet.impl;

import net.livingsky.framework.applet.AppletRequest;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;

/**
 * @author mikoto
 * @date 2022/4/15 18:20
 */
public class AppletRequestImpl implements AppletRequest {
    private final PlayerEvent playerEvent;

    public AppletRequestImpl(PlayerEvent playerEvent) {
        this.playerEvent = playerEvent;
    }

    @Override
    public Player getPlayer() {
        return playerEvent.getPlayer();
    }

    @Override
    public PlayerEvent getPlayerEvent() {
        return playerEvent;
    }
}
