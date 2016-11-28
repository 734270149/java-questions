package designpatterns.creationalpatterns.singleton;

/**
 * 懒汉式2
 * 整个方法进行同步，线程安全，但是锁粒度太大效率低
 * warn：多线程可能空指针异常
 * Created by shiguang3 on 2016/11/28.
 */
public class LanHan2 {

  private static LanHan2 instance;

  private LanHan2() {
  }

  public static synchronized LanHan2 getInstance() {
    if (instance == null) {
      instance = new LanHan2();
    }
    return instance;
  }
}
