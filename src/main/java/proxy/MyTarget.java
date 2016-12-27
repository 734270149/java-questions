package proxy;

/**
 * Created by shiguang3 on 2016/12/26.
 */
public class MyTarget implements MyInterface {
    public final void doSomeThing(String param) {
        System.out.println(param);
    }

    public String getSomeThing() {
        return "MyTarget";
    }
}
