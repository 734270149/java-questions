package number;

import com.google.gson.Gson;

import java.util.Comparator;

/**
 * Created by shiguang3 on 2016/11/2.
 */
public class Main {

  public static void main(String[] args) {
    Comparator<Integer> badComparator = new Comparator<Integer>() {
      public int compare(Integer thisVal, Integer anotherVal) {
        return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
      }
    };
    Integer i1 = 200;
    Integer i2 = 200;
    System.out.println(badComparator.compare(i1, i2));//输出1
    System.out.println(0.05 + 0.01);
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
