package proxy;

/**
 * Created by shiguang3 on 2016/12/27.
 */
public final class MyFinalTarget implements MyInterface {
    public void doSomeThing(String param) {
        System.out.println(param);
    }

    public String getSomeThing() {
        return "MyFinalTarget";
    }
}
