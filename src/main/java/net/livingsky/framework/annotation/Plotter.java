package net.livingsky.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mikoto
 * @date 2022/5/6 20:27
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Plotter {
    String value() default "";

    /**
     * @return The smaller the number, the higher the priority.
     */
    int priority() default 50;
}
