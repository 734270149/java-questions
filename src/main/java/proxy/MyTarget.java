package proxy;

/**
 * Created by shiguang3 on 2016/12/26.
 */
public class MyTarget {
    public void doSomeThing(String param) {
        System.out.println(param);
    }

    public String getSomeThing() {
        return "get";
    }
}
