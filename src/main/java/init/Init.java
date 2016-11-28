package init;

/**
 * 测试构造函数中执行时间较长的操作是否会有问题
 * Created by shiguang3 on 2016/11/28.
 */
public class Init {

  private Init() {
    try {
      //模拟时间较长的操作
      Thread.sleep(20000);
    } catch (Exception ignored) {
    }
  }

  public static void main(String[] args) {
    System.out.println(new Init());
  }
}
