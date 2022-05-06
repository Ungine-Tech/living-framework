package net.livingsky.framework.scanner;

import net.livingsky.framework.annotation.Service;
import net.livingsky.framework.manager.ServiceManager;

import java.lang.annotation.Annotation;
import java.util.Set;

import static net.livingsky.framework.util.ClassUtil.getClasses;


/**
 * @author mikoto
 * @date 2022/5/6 5:33
 */
public class ServiceScanner extends Scanner {
    public ServiceScanner(String packagePath) {
        super(packagePath);
    }

    /**
     * Scan the class in the package.
     *
     * @param targetPackagePath The package path.
     * @param serviceManager    The instance manager.
     */
    @Override
    public void doScan(String targetPackagePath, ServiceManager serviceManager) {
        Set<Class<?>> classes = getClasses(targetPackagePath);
        for (Class<?> clazz :
                classes) {
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation :
                    annotations) {
                if (annotation instanceof Service) {
                    serviceManager.saveServiceClass(((Service) annotation).value(), clazz);
                }
            }
        }
    }
}
