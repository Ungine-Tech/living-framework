package net.livingsky.framework.scanner.impl;

import net.livingsky.framework.annotation.Service;
import net.livingsky.framework.manager.ClassManager;
import net.livingsky.framework.scanner.Scanner;

import java.lang.annotation.Annotation;
import java.util.Set;

import static net.livingsky.framework.util.ClassUtil.getClasses;


/**
 * @author mikoto
 * @date 2022/5/6 5:33
 */
public class ServiceScannerImpl implements Scanner {
    /**
     * Scan the class in the package.
     *
     * @param targetPackagePath The package path.
     * @param classManager      The instance manager.
     */
    @Override
    public void doScan(String targetPackagePath, ClassManager classManager) {
        Set<Class<?>> classes = getClasses(targetPackagePath);
        for (Class<?> clazz :
                classes) {
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation :
                    annotations) {
                if (annotation instanceof Service) {
                    classManager.saveClass(((Service) annotation).priority(), ((Service) annotation).value(), clazz);
                }
            }
        }
    }
}
