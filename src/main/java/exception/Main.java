package exception;

/**
 * Created by shiguang3 on 2016/11/11.
 */
public class Main {

  public static void main(String[] args) {
    try {
      throw new NullPointerException();
    } finally {
      System.out.println("finally");
    }
  }
}
