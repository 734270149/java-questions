package proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by shiguang3 on 2016/12/26.
 */
public class MyCglibHandler implements MethodInterceptor {
    public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("--- start ---");
        System.out.println(Arrays.toString(objects));
        Object invokeSuper = methodProxy.invokeSuper(target, objects);
        System.out.println(invokeSuper);
        System.out.println("--- end ---");
        return invokeSuper;
    }
}
