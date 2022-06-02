package net.livingsky.framework.manager;

import java.util.Map;
import java.util.Set;

/**
 * @author mikoto
 * @date 2022/5/7 12:06
 */
public interface PackageManager {
    /**
     * Add a package to set.
     *
     * @param packageName         The package name.
     * @param packageScannerClass
     */
    void addPackage(String packageName, Class<?> packageScannerClass);

    /**
     * Get packages.
     *
     * @return The packages set.
     */
    Set<Map.Entry<String, Class<?>>> getPackages();
}
