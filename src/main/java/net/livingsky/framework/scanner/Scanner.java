package net.livingsky.framework.scanner;

import net.livingsky.framework.manager.ClassManager;

/**
 * @author mikoto
 * @date 2022/5/6 22:17
 */
public interface Scanner {
    /**
     * Scan the class in the package.
     *
     * @param targetPackagePath The package path.
     * @param classManager      The instance manager.
     */
    void doScan(String targetPackagePath, ClassManager classManager);
}
