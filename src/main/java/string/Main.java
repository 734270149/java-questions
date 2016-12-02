package string;

import java.util.regex.Pattern;

/**
 * Created by shiguang3 on 2016/11/9.
 */
public class Main {

  public static void main(String[] args) {
    System.out.println((int) ' ');
    System.out.println(' ');
    System.out.println((char) 160);
    String str = String.valueOf((char) 160);
    System.out.println("|" + str + "|");
    System.out.println("|" + str.trim() + "|");
    System.out.println("|" + str.replaceAll("\\u00A0", "") + "|");
    System.out.println("|" + Pattern.compile("\\u00A0").matcher(str).replaceAll("") + "|");
    System.out.println("|" + str.replace((char) 160, ' ').replace(" ", "") + "|");
    System.out.println("|" + str.replace("\\u00A0", "") + "|");
    System.out.println(
        "|" + Pattern.compile("\\u00A0", Pattern.LITERAL).matcher(str).replaceAll("") + "|");
  }
}
