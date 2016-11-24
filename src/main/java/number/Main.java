package number;

import com.google.gson.Gson;

/**
 * Created by shiguang3 on 2016/11/2.
 */
public class Main {

  public static void main(String[] args) {
    System.out.println(-1 / 0.0);
    System.out.println(0 / 0.0);
    System.out.println(1 / 0.0);
    System.out.println(1 / 0.0 == 5 / 0.0);
    System.out.println(Double.isNaN(Double.NaN));
    System.out.println(Double.isInfinite(Double.NaN));
    Gson gson = new Gson();
    System.out.println(Double.toString(Double.NaN));
    System.out.println(gson.toJson(Double.NaN, Double.class));
  }
}
