package designpatterns.creationalpatterns.singleton;

/**
 * 内部类式
 * 使用JVM本身的类加载机制保证了线程安全问题，
 * 效率高，不依赖jdk的版本
 * Created by shiguang3 on 2016/11/28.
 */
public class NeiBuLei {

  private NeiBuLei() {
  }

  public static NeiBuLei getInstance() {
    return Inner.INSTANCE;
  }

  private static final class Inner {

    private static final NeiBuLei INSTANCE = new NeiBuLei();
  }
}
