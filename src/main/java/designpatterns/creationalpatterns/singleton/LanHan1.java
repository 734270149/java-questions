package designpatterns.creationalpatterns.singleton;

/**
 * 懒汉式1
 * 线程不安全，并发下漏洞百出没啥说的。
 * Created by shiguang3 on 2016/11/28.
 */
public class LanHan1 {

  private static LanHan1 instance;

  private LanHan1() {
  }

  public static LanHan1 getInstance() {
    if (instance == null) {
      instance = new LanHan1();
    }
    return instance;
  }
}
