package sg;

/**
 * Created by shiguang3 on 2016/4/28.
 */
public class AA {

    private byte a;
    private byte b;
    private byte c;
    private byte d;
    private byte e;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AA aa = (AA) o;

        return a == aa.a && b == aa.b && c == aa.c && d == aa.d && e == aa.e;

    }

    @Override
    public int hashCode() {
        int result = (int) a;
        result = 31 * result + (int) b;
        result = 31 * result + (int) c;
        result = 31 * result + (int) d;
        result = 31 * result + (int) e;
        return result;
    }
}
