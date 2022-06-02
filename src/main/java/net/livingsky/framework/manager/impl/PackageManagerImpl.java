package net.livingsky.framework.manager.impl;

import net.livingsky.framework.manager.PackageManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author mikoto
 * @date 2022/5/7 12:10
 */
public class PackageManagerImpl implements PackageManager {
    Map<String, Class<?>> packageMap = new HashMap<>();

    /**
     * Add a package to set.
     *
     * @param packageName         The package name.
     * @param packageScannerClass The package scanner class.
     */
    @Override
    public void addPackage(String packageName, Class<?> packageScannerClass) {
        packageMap.put(packageName, packageScannerClass);
    }

    /**
     * Get packages.
     *
     * @return The packages set.
     */
    @Override
    public Set<Map.Entry<String, Class<?>>> getPackages() {
        return packageMap.entrySet();
    }
}
