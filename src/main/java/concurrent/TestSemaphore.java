package concurrent;

import java.util.concurrent.Semaphore;

/**
 * Created by shiguang3 on 2016/10/12.
 */
public class TestSemaphore {

  public static void main(String[] args) throws InterruptedException {
    final Semaphore semaphore = new Semaphore(2, true);
    for (int i = 4; i > 0; i--) {
      final int finalI = i;
      new Thread(new Runnable() {
        public void run() {
          try {
            semaphore.acquire();
            System.out.println(finalI + "s");
            Thread.sleep(finalI * 100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          } finally {
            semaphore.release(2);
            System.out.println(finalI + "e");
          }
        }
      }).start();
      Thread.sleep(50);
    }
  }
}
