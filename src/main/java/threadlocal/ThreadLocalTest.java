package threadlocal;

/**
 * 测试ThreadLocal用法
 *
 * @author zhangdongyang
 * @update shiguang3
 */
public class ThreadLocalTest {


  /***
   * 赋初始值
   */
  private static final ThreadLocal<Integer> threadNum = new ThreadLocal<Integer>() {
    @Override
    protected Integer initialValue() {
      return 5;
    }
  };

  public static void main(String[] args) {
    ThreadLocalTest test = new ThreadLocalTest();
    ThreadClient client1 = new ThreadClient(test);
    ThreadClient client2 = new ThreadClient(test);
    ThreadClient client3 = new ThreadClient(test);
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
    threadNum.set(threadNum.get() + 1);
    return threadNum.get();
  }

  private static final class ThreadClient extends Thread {

    private ThreadLocalTest test;

    public ThreadClient(ThreadLocalTest test) {
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
}
