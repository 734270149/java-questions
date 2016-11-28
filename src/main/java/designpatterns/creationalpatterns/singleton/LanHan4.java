package designpatterns.creationalpatterns.singleton;

/**
 * 懒汉式4
 * 3的改进版，变量加了关键字volatile修饰，
 * 采用volatile关键字，禁止指令重排的特性，防止空指针异常的问题
 * warn：该特性在jdk1.5及以上才好使
 * Created by shiguang3 on 2016/11/28.
 */
public class LanHan4 {

  private static volatile LanHan4 instance;

  private LanHan4() {
  }

  public static LanHan4 getInstance() {
    if (instance == null) {
      synchronized (LanHan4.class) {
        if (instance == null) {
          instance = new LanHan4();
        }
      }
    }
    return instance;
  }
}
