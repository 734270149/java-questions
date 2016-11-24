package sg;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import redis.clients.jedis.Jedis;

public class Main {

  public static void main(String[] args) {
    System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
    System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    System.out.println(Integer.MIN_VALUE == Math.abs(Integer.MIN_VALUE));
    System.out.println(Integer.MIN_VALUE < 0);
//        jedis();
//        String[] split = "商家编号,商家名称,库房,业务日期,出入库类型,计费动作,单据编号,单据类型,销售平台单据号,商品代码,商品名称,数量,实收金额,数据状态,业务类型,商品销售属性,首件价格,首件数,续件价格,商家折扣".split(",");
//        System.out.println(split.length);
//        System.out.println(Arrays.toString(split));
  }

  private static void listIterator() {
    ArrayList<Integer> objects = new ArrayList<Integer>();
    objects.add(1);
    objects.add(2);
    objects.add(3);
    ListIterator<Integer> iterator = objects.listIterator();
    iterator.next();
    iterator.previous();
    iterator.set(5);
    System.out.println(objects);
  }

  private static <t extends Integer & List & Iterator> boolean getT() {
    return true;
  }

  private static void testSwitch() {
    int id2 = 2;
    class Obj {

      int id;

      public final int getId() {
        return id;
      }
    }
    Obj obj = new Obj();
    obj.id = 1;
    final int id = 1;//不能使用对象赋值obj.id;
    //jdk 1.6
    //The type of the Expression must be :
    // char, byte, short, int,
    // Character, Byte, Short, Integer,
    // or an enum type (§8.9),
    // or a compile-time error occurs.
    switch (obj.getId()) {
      case id:
        System.out.println(1);
        break;
      //Constant expression required
//            case id2:
//                System.out.println(2);
//                break;
      default:
    }
  }

  private static void jedis() {
    Jedis jedis = new Jedis("127.0.0.1");
    jedis.auth("20112158");
    jedis.select(0);
//        jedis.hset("bb", "", "22");
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "2");
    map.put("2", "2");
    map.put("3", "2");
    jedis.hmset("aa", map);
    Map<String, String> map1 = jedis.hgetAll("vv");
    System.out.println(map1);
//        List<String> cc = jedis.hmget("aa", "1", "5", "2");
//        List<String> dd = jedis.hmget("aa", "1", "2");
    String aa = jedis.hget("aa", "4");
    System.out.println(aa);
  }

  private static void treeReg() {
    TreeSet<Integer> set = new TreeSet<Integer>(new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    set.add(1);
    set.add(2);
    for (Integer integer : set) {
      System.out.println(integer);
    }

    String regex = "\\s+FROM\\s+";
    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher("select * from ");
    while (matcher.find()) {
      int fromStartIndex = matcher.start(0);
      String text = "select * from".substring(0, fromStartIndex);
      System.out.println(fromStartIndex);
      System.out.println(text);
    }
  }

  private static void get() {
    Map<Key, String> keyStringMap = new HashMap<Key, String>();
    Key key = new Key();
    key.num = new BigDecimal(7);
    keyStringMap.put(key, "qqq");
    key.num = new BigDecimal(5);
    System.out.println(keyStringMap.get(key));
    System.out.println("a,,b,".split(",").length);
    ann(null);
  }

  private static void ann(Object o) {
    if (o == null) {
      throw new NullPointerException();
    }
  }

  private static void bb() {
    System.out.println(Pattern.compile("^.*R\\.(?!id).*").matcher("R.id").matches());
    System.out.println(Pattern.compile("^.*R\\.(?!id).*").matcher("  R.id").matches());
    System.out.println(Pattern.compile("^.*R\\.(?!id).*").matcher(" R.layout").matches());
    try {
      cuoWu();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void meiJu() {
    System.out.println(BizType.WAREHOUSEFEE.toString());
    System.out.println(BizType.WAREHOUSEFEE.getCode());
    System.out.println(BizType.WAREHOUSEFEE.getName());
    UUID uuid = UUID.randomUUID();
    System.out.println(uuid.toString().replace("-", "").length());
    System.out.println(String.valueOf(Long.MIN_VALUE).length());
    System.out.println(String.valueOf(Integer.MIN_VALUE).length());
    System.out.println(Integer.MIN_VALUE);
    System.out.println(Long.valueOf("9223372036854775807"));
    System.out.println("" + null);
  }

  private static void subList() {
    System.out.println(new BigDecimal("1.2"));
    System.out.println(new BigDecimal("2.0"));
    System.out.println(new BigDecimal("3"));
    System.out.println(Arrays.toString("1".split(",")));
    HashMap<Integer, ArrayList<String>> param = new HashMap<Integer, ArrayList<String>>();
    ArrayList<String> c = new ArrayList<String>();
    c.add("1");
    c.add("2");
    c.add("3");
    System.out.println("sub:" + c.subList(1, 3));
    ArrayList<String> b = new ArrayList<String>();
    b.add("4");
    b.add("5");
    b.add("6");
    param.put(1, c);
    param.put(2, b);
    System.out.println("result=" + getString(param));
    System.out.println(signum(5));
    System.out.println(signum(0));
    System.out.println(signum(-5));
    System.out.println(Integer.toBinaryString(signum(5)));
  }

  private static int signum(int i) {
    // HD, Section 2-7
    return (i >> 31) | (-i >>> 31);
  }

  private static void Decimal() {
    BigDecimal divide = new BigDecimal(5);
    divide = divide.divide(new BigDecimal(3), 4, BigDecimal.ROUND_HALF_UP);
    System.out.println(divide);
    System.out
        .println(new Range(new BigDecimal(4), null).compareTo(new Range(new BigDecimal(2), null)));
    TreeSet<Range> a = new TreeSet<Range>();
    a.add(new Range(new BigDecimal(4), null));
    a.add(new Range(new BigDecimal(2), null));
    a.add(new Range(new BigDecimal(1), null));
    System.out.println(a);
  }

  private static int highestOneBit(int i) {
    // HD, Figure 3-1
    i |= (i >> 1);
    i |= (i >> 2);
    i |= (i >> 4);
    i |= (i >> 8);
    i |= (i >> 16);
    return i - (i >>> 1);
  }

  public static HashMap<String, ArrayList<String>> getString(
      Map<Integer, ArrayList<String>> param) {
    ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
    StringBuilder keyBuilder = new StringBuilder(param.size() << 2);
    for (Map.Entry<Integer, ArrayList<String>> entry : param.entrySet()) {
      Integer key = entry.getKey();
      ArrayList<String> values = entry.getValue();
      ArrayList<String> results = new ArrayList<String>(values.size());
      for (String value : values) {
        results.add(key + ":" + value);
      }
      all.add(results);
      keyBuilder.append(key).append(",");
    }
    ArrayList<String> result = all.get(0);
    for (int i = 1, length = all.size(); i < length; i++) {
      ArrayList<String> strings = all.get(i);
      ArrayList<String> temps = new ArrayList<String>();
      for (String aResult : result) {
        for (String string : strings) {
          temps.add(aResult + "," + string);
        }
      }
      result = temps;
    }
    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    map.put(keyBuilder.substring(0, keyBuilder.length() - 1), result);
    return map;
  }

  private static void cuoWu() throws ClassNotFoundException {
    throw new ClassNotFoundException();
  }

  private void date() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
      sdf.parse("2036-12-31");
      System.out.println(sdf.format(new Date()));
      System.out.println(System.currentTimeMillis());
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("56".compareTo("19"));
    System.out.println(highestOneBit(-8));
    System.out.println(15 >>> 1);
    System.out.println(Integer.toBinaryString(-8));
    System.out.println(~-8);
  }

  private void fenGe() {
    System.out.println(Arrays.toString("5.17".split("\\.")));
    System.out.println("5.17".split("\\.").length);
    System.out.println(Arrays.toString("5.17".split(".")));
    System.out.println("5.17".split(".").length);
  }

  private void fanShe() {
    try {
      Class<?> main = Class.forName("com.sg.MeiJu");
      Method[] methods = main.getMethods();
      Method[] declaredMethods = main.getDeclaredMethods();
      Field[] fields = main.getFields();
      Field[] declaredFields = main.getDeclaredFields();
      System.out.println(Arrays.toString(methods));
      System.out.println(Arrays.toString(declaredMethods));
      System.out.println(Arrays.toString(fields));
      System.out.println(Arrays.toString(declaredFields));
      System.out.println(Arrays.toString(MeiJu.meiJus));
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private void first() {
    String str = "JSP00123";
    System.out.println(str.replaceAll("[a-zA-Z]", ""));
    char c = 97;
    System.out.println((int) 'a');
    System.out.println(c);
    System.out.println((int) c);
    System.out.println(-2 >>> 1);
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Byte.SIZE);
    TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
    treeMap.put(1, "");
    treeMap.put(3, "");
    treeMap.put(2, "");
    System.out.println(treeMap.toString());

    HashMap<String, String> mUsualInvoiceList = new HashMap<String, String>();
    mUsualInvoiceList.put("1", "1");
    mUsualInvoiceList.put("2", "2");
    mUsualInvoiceList.put("3", "3");
    ArrayList<String> mUsualInvoiceListContent = new ArrayList<String>();
//        Set<Map.Entry<String, Object>> entries = mUsualInvoiceList.entrySet();
    //内部是靠迭代器实现，仅在第一次调用entrySet()方法，以后就用迭代器循环，这么写OK
    for (Map.Entry<String, String> entry : mUsualInvoiceList.entrySet()) {
      mUsualInvoiceListContent.add(entry.getValue());
    }
    //每次选环结束进入下次循环之前都得进去size()方法去获取大小，这么写不好
    for (int i = 0; i < mUsualInvoiceListContent.size(); i++) {
      System.out.println();
    }

    //true or false 是否保留分隔的逗号
    StringTokenizer stringTokenizer = new StringTokenizer("a,b,c", ",", true);
    System.out.println(stringTokenizer.nextToken() + stringTokenizer.nextToken());
  }

  static class Key implements Comparable<Key> {

    BigDecimal num;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Key key = (Key) o;

      return num != null ? num.equals(key.num) : key.num == null;

    }

    @Override
    public int hashCode() {
      return num != null ? num.hashCode() : 0;
    }

    public int compareTo(Key o) {
      return hashCode() - o.hashCode();
    }
  }
}
