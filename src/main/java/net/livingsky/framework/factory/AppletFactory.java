package net.livingsky.framework.factory;

import net.livingsky.framework.applet.AppletRequest;
import net.livingsky.framework.applet.AppletResponse;
import net.livingsky.framework.applet.impl.AppletRequestImpl;
import net.livingsky.framework.applet.impl.AppletResponseImpl;
import net.livingsky.framework.plugin.LivingJavaPlugin;
import org.bukkit.event.player.PlayerEvent;

/**
 * @author mikoto
 * @date 2022/4/15 18:13
 */
public class AppletFactory {
    private static final AppletFactory INSTANCE = new AppletFactory();

    private AppletFactory() {
    }

    public static AppletFactory getInstance() {
        return INSTANCE;
    }

    public AppletRequest createAppletRequest(PlayerEvent playerEvent) {
        return new AppletRequestImpl(playerEvent);
    }

    public AppletResponse createAppletResponse(LivingJavaPlugin livingJavaPlugin) {
        return new AppletResponseImpl(livingJavaPlugin);
    }
}
