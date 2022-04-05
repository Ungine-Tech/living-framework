package net.livingsky.framework.applet;

import org.bukkit.event.Listener;

/**
 * @author mikoto
 * @date 2022/4/3 23:29
 */
public interface Applet extends Listener {

    /**
     * Applet handle.
     *
     * @param appletRequest  The applet request.
     * @param appletResponse The applet response.
     */
    void appletHandle(AppletRequest appletRequest, AppletResponse appletResponse);
}
