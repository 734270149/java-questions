package collection;

/**
 * Created by shiguang3 on 2016/9/9.
 */
public class Main {

  public static void main(String[] args) {
    Key key = new Key();
    System.out.println((3L << 42));
    System.out.println(mergeId((1 << 22) + 5, 1L));
    System.out.println(mergeId(5, 1L));
  }

  public static long mergeId(long sellerPart, long orderPart) {
    long result = sellerPart << 42 | orderPart;
    return result;
  }
}
