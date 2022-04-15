package net.livingsky.framework.applet.impl;

import net.livingsky.framework.applet.Applet;
import net.livingsky.framework.applet.AppletManager;
import net.livingsky.framework.applet.AppletResponse;
import net.livingsky.framework.factory.AppletFactory;
import net.livingsky.framework.plugin.LivingJavaPlugin;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;

/**
 * @author mikoto
 * @date 2022/4/3 22:41
 */
public class AppletManagerImpl implements AppletManager {
    LivingJavaPlugin livingJavaPlugin;

    public AppletManagerImpl(LivingJavaPlugin livingJavaPlugin) {
        this.livingJavaPlugin = livingJavaPlugin;
    }

    /**
     * Register applet.
     *
     * @param applet The applet class.
     */
    @Override
    public void registerApplet(@NotNull Applet applet) {
        Class<? extends Event> appletEvent = null;
        EventPriority eventPriority = null;

        for (Annotation annotation :
                applet.getClass().getAnnotations()) {
            if (annotation instanceof net.livingsky.framework.annotation.Applet) {
                appletEvent = ((net.livingsky.framework.annotation.Applet) annotation).event();
                eventPriority = ((net.livingsky.framework.annotation.Applet) annotation).eventPriority();
            }
        }

        if (appletEvent != null) {
            livingJavaPlugin
                    .getServer()
                    .getPluginManager()
                    .registerEvent(
                            appletEvent,
                            applet,
                            eventPriority,
                            (listener, event) -> {
                                if (listener instanceof Applet && event instanceof PlayerEvent) {
                                    AppletResponse appletResponse;
                                    try {
                                        appletResponse = ((Applet) listener).appletHandle(
                                                AppletFactory.getInstance().createAppletRequest((PlayerEvent) event),
                                                AppletFactory.getInstance().createAppletResponse(livingJavaPlugin)
                                        );
                                        appletResponse.getPlotter().produceAll(((PlayerEvent) event).getPlayer(), appletResponse.getScene());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            },
                            livingJavaPlugin);
        } else {
            throw new NullPointerException();
        }
    }
}
