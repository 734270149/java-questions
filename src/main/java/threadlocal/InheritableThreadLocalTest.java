package threadlocal;

/**
 * InheritableThreadLocal子线程继承父线程的状态
 * Created by shiguang3 on 2016/12/1.
 */
public class InheritableThreadLocalTest {

  private static final InheritableThreadLocal<Integer>
      LOCAL = new InheritableThreadLocal<Integer>() {
    @Override
    protected Integer initialValue() {
      return 0;
    }
  };

  public static void main(String[] args) {
    InheritableThreadLocalTest test = new InheritableThreadLocalTest();
    LOCAL.set(4);
    ThreadClient client1 = new ThreadClient(test, "1");
    ThreadClient client2 = new ThreadClient(test, "2");
    ThreadClient client3 = new ThreadClient(test, "3");
    client1.start();
    client2.start();
    client3.start();
  }

  /**
   * 获取下一个序列值
   *
   * @return
   */
  public int getNextNum() {
    LOCAL.set(LOCAL.get() + 1);
    return LOCAL.get();
  }

  private static final class ThreadClient extends Thread {

    private InheritableThreadLocalTest test;
    private String s;

    public ThreadClient(InheritableThreadLocalTest test, String s) {
      super(s);
      this.s = s;
      this.test = test;
    }

    public void run() {
      for (int i = 0; i < 3; i++) {
        System.out.println(
            "当前的线程----->" + Thread.currentThread().getName() + "-------test[" + test.getNextNum()
            + "]");
      }
      SonThreadClient client = new SonThreadClient(test, s + ".1");
      client.start();
    }
  }

  private static final class SonThreadClient extends Thread {

    private InheritableThreadLocalTest test;

    public SonThreadClient(InheritableThreadLocalTest test, String s) {
      super(s);
      this.test = test;
    }

    public void run() {
      for (int i = 0; i < 3; i++) {
        System.out.println(
            "当前的线程----->" + Thread.currentThread().getName() + "-------test[" + test.getNextNum()
            + "]");
      }
    }
  }
}
