package tongbu;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shiguang3 on 2016/9/8.
 */
public class TongBu {

  private static Set<String> strings;

  public static void main(String[] args) throws InterruptedException {
//    latch();
    HashMap<String,String> hashMap = new HashMap<String, String>();
    strings = hashMap.keySet();
    hashMap.put("1","2");
    //strings.add("s");
    System.out.println(strings.getClass());
  }

  private static void latch() throws InterruptedException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    int total = 3;
    final CountDownLatch countDownLatch = new CountDownLatch(total);
    for (int i = 0; i < total; i++) {
      executorService.execute(new Runnable() {
        public void run() {
          System.out.println(Thread.currentThread());
          countDownLatch.countDown();
        }
      });
    }
    countDownLatch.await();
    executorService.shutdown();
    System.out.println(Thread.currentThread());
  }
}
