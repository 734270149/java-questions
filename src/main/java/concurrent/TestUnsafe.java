package concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by shiguang3 on 2016/11/3.
 */
public class TestUnsafe {

  public static void main(String[] args)
      throws NoSuchFieldException, IllegalAccessException, InstantiationException,
             NoSuchMethodException, InvocationTargetException {

    Constructor<Unsafe> declaredConstructor = Unsafe.class.getDeclaredConstructor();
    declaredConstructor.setAccessible(true);
    Unsafe unsafe1 = declaredConstructor.newInstance();
    System.out.println(unsafe1);

    System.out.println(System.out.getClass());
    Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
    theUnsafe.setAccessible(true);
    Unsafe unsafe = (Unsafe) theUnsafe.get(null);

    long i = unsafe.objectFieldOffset(In.class.getDeclaredField("i"));
    In in = new In();
    in.i = 1;
    boolean b = unsafe.compareAndSwapInt(in, i, 1, 2);
    System.out.println(i);
    System.out.println(b);

    In2 in2 = (In2) unsafe.allocateInstance(In2.class);
    System.out.println(in2.i2);
    System.out.println(in2.i3);
    System.out.println(new In2().i2);
    System.out.println(new In2().i3);

    In3 in3 = (In3) unsafe.allocateInstance(In3.class);
    System.out.println(in3 == null);
    assert in3 != null;
    in3.setText("in3");
    System.out.println(in3);
    System.out.println(In3.a);
    System.out.println(In3.b);

    int[] ints = new int[]{1, 2, 3};
    Object instance = Array.newInstance(int.class, 2, 3);
    Object[] o1 = (Object[]) instance;// size 2
    int[][] ints1 = new int[3][6];
    Object[] o2 = ints1;//size 3
    System.out.println(instance);
    Object o = Array.get(ints, 2);
    System.out.println(o);
    int anInt = Array.getInt(ints, 2);
    System.out.println(anInt);

    Object of = 0.0;
    System.out.println(of.getClass());
  }

  private enum In3 {
    a("a"), b("b");

    private String text;

    In3(String text) {
      this.text = text;
    }

    private void setText(String text) {
      this.text = text;
    }

    @Override
    public String toString() {
      return text;
    }
  }

  private static final class In {

    private volatile int i;
  }

  private static final class In2 {

    private volatile int i3 = 3;

    private volatile int i2;

    private In2() {
      this.i2 = 5;
    }
  }
}
