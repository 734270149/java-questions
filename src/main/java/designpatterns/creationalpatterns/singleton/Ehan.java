package designpatterns.creationalpatterns.singleton;

/**
 * 饿汉式
 * 缺点1：
 * 在类一加载进虚拟机就初始化了单例对象，在某些情况下会造成资源的浪费，
 * 例如初始化的对象包含特别多的数据占用大量内存，但是一直没有地方调用{@link #getInstance()}方法。
 * 缺点2：
 * 当创建实例依赖于一些其他操作时，这种方式很不方便，
 * 将依赖的操作例如读取配置文件，放到构造函数里，是一种不太好的解决方案。
 * Created by shiguang3 on 2016/11/28.
 */
public class Ehan {

  private static final Ehan INSTANCE = new Ehan();

  private Ehan() {
  }

  public static Ehan getInstance() {
    return INSTANCE;
  }
}
