package generic;

/**
 * Created by shiguang3 on 2017/2/8.
 */
public class Test {
  public static void main(String[] args) throws InstantiationException, IllegalAccessException {
    Generic<String> hasType = new Generic<String>();
    Generic noType = new Generic();
    String hasG = hasType.global();
    Object noG = noType.global();
    Integer hasM = hasType.method(Integer.class);
    Object noM = noType.method(Integer.class);
  }
}