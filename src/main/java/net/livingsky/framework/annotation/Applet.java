package net.livingsky.framework.annotation;

import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;

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

    String plotterName();

    Class<? extends Event> event();

    EventPriority eventPriority() default EventPriority.NORMAL;
}
