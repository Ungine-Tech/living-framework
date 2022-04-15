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
     * @return Applet response.
     * @throws Exception An exception.
     */
    AppletResponse appletHandle(AppletRequest appletRequest, AppletResponse appletResponse) throws Exception;
}
