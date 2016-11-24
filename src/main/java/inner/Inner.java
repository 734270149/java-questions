package inner;

/**
 * Created by shiguang3 on 2016/9/21.
 */
class Inner {

  public static void main(String[] args) {
    System.out.println(3 * 0.1);
  }

  private class Key {

    void getKey() {
    }
  }

  private final class Value extends Key {

    void getValue() {
      getKey();
    }
  }
}
