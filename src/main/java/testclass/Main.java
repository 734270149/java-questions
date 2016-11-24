package testclass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shiguang3 on 2016/9/8.
 */
public class Main {

  public static void main(String[] args) {
    ClassLoader.getSystemClassLoader();
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    ExecutorService executorService1 = Executors.newSingleThreadExecutor();
    for (int i = 0; i < 3; i++) {
      final int finalI = i;
      executorService.execute(new Runnable() {
        public void run() {
          int i1 = finalI / (finalI - 1);
          System.out.println("a" + Thread.currentThread());
        }
      });
      executorService1.execute(new Runnable() {
        public void run() {
          int i1 = finalI / (finalI - 1);
          System.out.println("b" + Thread.currentThread());
        }
      });
    }
  }
}
