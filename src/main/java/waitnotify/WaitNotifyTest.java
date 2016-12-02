package waitnotify;

/**
 * Created by shiguang3 on 2016/12/2.
 */
public class WaitNotifyTest {

  public static void main(String[] args) throws Exception {
    Object a = new Object();
    Object b = new Object();
    Object c = new Object();
    MyRun pa = new MyRun("A", c, a);
    MyRun pb = new MyRun("B", a, b);
    MyRun pc = new MyRun("C", b, c);

    new Thread(pa).start();
    Thread.sleep(100);  //确保按顺序A、B、C执行
    new Thread(pb).start();
    Thread.sleep(100);
    new Thread(pc).start();
    Thread.sleep(100);
  }

  private static final class MyRun implements Runnable {

    private final Object prev;
    private final Object self;
    private String name;

    private MyRun(String name, Object prev, Object self) {
      this.name = name;
      this.prev = prev;
      this.self = self;
    }

    public void run() {
      int count = 5;
      while (count > 0) {
        synchronized (prev) {
          synchronized (self) {
            System.out.print(name);
            count--;
            self.notify();
          }
          try {
            if (count > 0) {
              prev.wait();
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
