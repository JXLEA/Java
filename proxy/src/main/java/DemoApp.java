import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class DemoApp {

    public static void main(String[] args) {
        GreetingService helloService = createMethodLoggingProxy(GreetingService.class);
        helloService.hello(); // logs nothing to the console
        helloService.gloryToUkraine(); // logs method invocation to the console
    }

    /**
     * Creates a proxy of the provided class that logs its method invocations. If a method that
     * is marked with {@link LogInvocation} annotation is invoked, it prints to the console the following statement:
     * "[PROXY: Calling method '%s' of the class '%s']%n", where the params are method and class names accordingly.
     *
     * @param targetClass a class that is extended with proxy
     * @param <T>         target class type parameter
     * @return an instance of a proxy class
     */
    public static <T> T createMethodLoggingProxy(Class<T> targetClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, proxy) -> {
            if (Stream.of(method.getDeclaredAnnotations())
                    .anyMatch(annotation -> annotation.annotationType().getName().equals(LogInvocation.class.getName()))) {
                System.out.println((String.format("[PROXY: Calling method '%s' of the class '%s']%n", method.getName(), o.getClass().getName())));
                return method.getDefaultValue();
            } else {
                return proxy.invokeSuper(o, objects);
            }
        });
        return (T) enhancer.create();
    }
}
