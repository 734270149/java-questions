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
        cglib(MyTarget.class);
        System.out.println("==========");
        //final的class用cglib代理会报错，因为cglib是通过产生目标类的子类的方式进行代理的
        //因此cglib代理也不能代理final方法，
        //Proxy可以代理对象的final方法，因为Proxy是通过反射进行代理
        cglib(MyFinalTarget.class);
    }

    private static <T extends MyInterface> void cglib(Class<T> param) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(param);
        enhancer.setCallback(new MyCglibHandler());
        try {
            T myTarget = (T) enhancer.create();
            myTarget.doSomeThing(myTarget.getSomeThing());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
