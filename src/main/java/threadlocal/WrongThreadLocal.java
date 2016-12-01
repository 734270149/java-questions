package threadlocal;

/**
 * 错误用法示例
 * Created by shiguang3 on 2016/12/1.
 */
public class WrongThreadLocal {

  private static final Inner INNER = new Inner();
  private static final ThreadLocal<Inner> LOCAL = new ThreadLocal<Inner>() {
    @Override
    protected Inner initialValue() {
      return INNER;
      //正确用法：return new Inner();初始化的变量不应用公共可变的对象
      //我觉得在用ThreadLocal时泛型最好是Integer，String这种不可变的对象
    }
  };

  public static void main(String[] args) {
    WrongThreadLocal test = new WrongThreadLocal();
    ThreadClient client1 = new ThreadClient(test);
    ThreadClient client2 = new ThreadClient(test);
    ThreadClient client3 = new ThreadClient(test);
    client1.start();
    client2.start();
    client3.start();
  }

  /**
   * 获取下一个序列值
   * 由于这个方法不是原子性操作所以可能导致打印出的数据不符合预期，
   * 此类只为测试ThreadLocal的一种错误用法，不讨论并发，因此把方法加同步锁，防止显示出来的数字错乱
   *
   * @return
   */
  public synchronized int getNextNum() {
    Inner inner = LOCAL.get();
    inner.num += 1;
    LOCAL.set(inner);
    return LOCAL.get().num;
  }

  private static class ThreadClient extends Thread {

    private WrongThreadLocal test;

    public ThreadClient(WrongThreadLocal test) {
      this.test = test;
    }

    public void run() {
      for (int i = 0; i < 3; i++) {
        System.out.println(
            "当前的线程----->" + Thread.currentThread().getName() + ",-------test[" + test.getNextNum()
            + "]");
      }
    }
  }

  private static final class Inner {

    private int num;
  }
}
