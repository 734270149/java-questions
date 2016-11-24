package refactor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiguang3 on 2016/8/11.
 */
public class Run {
    public static void main(String[] args) {

        aController();

        bController();
    }

    private static void aController() {
        List<A> aList = new ArrayList<A>();
        checkList(aList, new Inter<A>() {
            public String check(A a) {
                if (a.getLength() < 0) {
                    return "length";
                }
                return null;
            }
        });
    }

    private static void bController() {
        List<B> bList = new ArrayList<B>();
        checkList(bList, new Inter<B>() {
            public String check(B b) {
                if (b.getWeight() < 0) {
                    return "weight";
                }
                return null;
            }
        });
    }

    private static <T extends Base> String checkList(List<T> list, Inter<T> i) {
        for (T t : list) {
            int id = t.getId();
            if (id < 0) {
                return "id";
            }
            String check = i.check(t);
            if (check != null && check.length() > 0) {
                return check;
            }

        }
        return "success";
    }

    private interface Inter<T> {
        String check(T t);
    }
}
