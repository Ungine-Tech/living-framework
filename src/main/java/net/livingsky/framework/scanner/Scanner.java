package net.livingsky.framework.scanner;

import net.livingsky.framework.manager.ServiceManager;

/**
 * @author mikoto
 * @date 2022/5/6 5:42
 */
public abstract class Scanner {
    protected final String packagePath;

    public Scanner(String packagePath) {
        this.packagePath = packagePath;
    }

    /**
     * Scan the class in the package.
     *
     * @param targetPackagePath The package path.
     * @param serviceManager    The instance manager.
     */
    public abstract void doScan(String targetPackagePath, ServiceManager serviceManager);
}
