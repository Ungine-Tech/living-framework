package net.livingsky.framework;

import net.livingsky.framework.manager.ClassManager;
import net.livingsky.framework.manager.InstanceManager;
import net.livingsky.framework.manager.PackageManager;
import net.livingsky.framework.manager.impl.ClassManagerImpl;
import net.livingsky.framework.manager.impl.InstanceManagerImpl;
import net.livingsky.framework.manager.impl.PackageManagerImpl;

/**
 * @author mikoto
 * @date 2022/5/7 12:08
 */
public class SimpleFramework {
    private static final InstanceManager<Object> INSTANCE_MANAGER = new InstanceManagerImpl();
    private static final ClassManager CLASS_MANAGER = new ClassManagerImpl();
    private static final PackageManager PACKAGE_MANAGER = new PackageManagerImpl();

    private static final SimpleFramework INSTANCE = new SimpleFramework();

    private SimpleFramework() {
    }

    public static SimpleFramework getInstance() {
        return INSTANCE;
    }

    public InstanceManager<Object> getInstanceManager() {
        return INSTANCE_MANAGER;
    }

    public ClassManager getClassManager() {
        return CLASS_MANAGER;
    }

    public PackageManager getPackageManager() {
        return PACKAGE_MANAGER;
    }
}
