package net.livingsky.framework.applet;

import org.bukkit.event.Event;

/**
 * @author mikoto
 * @date 2022/4/5 0:03
 */
public record AppletRequest(Event event) {

    public Event getEvent() {
        return event;
    }
}
