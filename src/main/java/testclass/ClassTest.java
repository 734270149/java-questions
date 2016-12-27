package testclass;

/**
 * Created by shiguang3 on 2016/12/27.
 */
public class ClassTest {
    public static void main(String[] args) {
        System.out.println(Child.class.isAssignableFrom(Father.class));
        System.out.println(Father.class.isAssignableFrom(Father.class));
        System.out.println(Father.class.isAssignableFrom(Child.class));
    }

    private interface Father {
    }

    private static final class Child implements Father {
    }
}
