package sg;

/**
 * Created by shiguang3 on 2016/3/14.
 */
public enum MeiJu {
  A, B {
    @Override
    public void go() {
      System.out.println("B");
    }
  };
  public static final MeiJu[] meiJus;

  static {
    meiJus = MeiJu.values();
  }

  public void go() {
    System.out.println("go");
  }
}
