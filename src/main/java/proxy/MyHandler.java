package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by shiguang3 on 2016/12/26.
 */
public class MyHandler implements InvocationHandler {

    private final MyInterface myInterface;

    public MyHandler(MyInterface myInterface) {
        this.myInterface = myInterface;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--- start ---");
        System.out.println(Arrays.toString(args));
        Object invoke = method.invoke(myInterface, args);
        System.out.println(invoke);
        System.out.println("--- end ---");
        return invoke;
    }
}
