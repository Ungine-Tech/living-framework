package net.livingsky.framework.plugin;

import net.livingsky.framework.manager.ClassManager;
import net.livingsky.framework.manager.InstanceManager;
import net.livingsky.framework.manager.impl.ClassManagerImpl;
import net.livingsky.framework.manager.impl.InstanceManagerImpl;

/**
 * @author mikoto
 * @date 2022/6/3 2:44
 */
public class Living {
    public static final ClassManager CLASS_MANAGER = new ClassManagerImpl();
    public static final InstanceManager INSTANCE_MANAGER = new InstanceManagerImpl();
}
