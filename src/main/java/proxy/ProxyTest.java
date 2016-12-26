package proxy;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * Created by shiguang3 on 2016/12/26.
 */
public class ProxyTest {
    public static void main(String[] args) {
        MyInterface instance = (MyInterface) Proxy.newProxyInstance(MyImpl.class.getClassLoader(), MyImpl.class.getInterfaces(), new MyHandler(new MyImpl()));
        instance.doSomeThing(instance.getSomeThing());

        System.out.println("==========");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyTarget.class);
        enhancer.setCallback(new MyCglibHandler());
        MyTarget myTarget = (MyTarget) enhancer.create();
        myTarget.doSomeThing(myTarget.getSomeThing());
    }
}
