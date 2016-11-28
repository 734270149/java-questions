package designpatterns.creationalpatterns.singleton;

/**
 * 懒汉式3
 * 双重检验锁，降低锁粒度，相对于2效率高
 * warn：多线程可能空指针异常
 * Created by shiguang3 on 2016/11/28.
 */
public class LanHan3 {

  private static LanHan3 instance;

  private LanHan3() {
  }

  public static LanHan3 getInstance() {
    if (instance == null) {
      synchronized (LanHan3.class) {
        if (instance == null) {
          instance = new LanHan3();
        }
      }
    }
    return instance;
  }
}
