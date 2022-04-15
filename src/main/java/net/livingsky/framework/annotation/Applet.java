package net.livingsky.framework.annotation;

import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerEvent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mikoto
 * @date 2022/4/5 14:21
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Applet {
    String value();

    Class<? extends PlayerEvent> event();

    EventPriority eventPriority() default EventPriority.NORMAL;
}
