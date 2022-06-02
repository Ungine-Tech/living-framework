package net.livingsky.framework.event;

import net.livingsky.framework.SimpleFramework;
import net.livingsky.framework.loader.Loader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;

import java.lang.reflect.InvocationTargetException;

/**
 * @author mikoto
 * @date 2022/5/7 11:16
 */
public class ClassLoad implements Listener {
    @EventHandler
    public void load(ServerLoadEvent serverLoadEvent) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ((Loader) SimpleFramework.getInstance().getInstanceManager().getInstance(Loader.class, "ClassLoader")).doLoad(SimpleFramework.getInstance().getClassManager(), SimpleFramework.getInstance().getInstanceManager());
    }
}
