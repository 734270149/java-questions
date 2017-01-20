package string;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by shiguang3 on 2016/12/7.
 */
public class StringAppendTest {

  public static void main(String[] args) throws Exception {
    String s1 = "abc";
    String s2 = "abc";
    //Per the Java Language Specification, compile-time constant strings are automatically interned, making the call to String.intern() redundant.
    String s3 = "abc".intern();
    String s4 = "abcd".substring(0, 3);
    String s5 = "abcd".substring(0, 3).intern();
    System.out.println(s1 == s2);
    System.out.println(s2 == s3);
    System.out.println(s3 == s4);
    System.out.println(s4 == s5);
    System.out.println(s3 == s5);
//    append();
  }

  private static void append() throws IOException {
    Properties properties = new Properties();
    properties.load(StringAppendTest.class.getClassLoader().getResourceAsStream("config.properties"));
    String a = properties.getProperty("string");
    //final String a = "a";
    //执行javap –verbose StringAppendTest或javap –c StringAppendTest，可以看到字节码
    //当a是读取配置文件，单行加号拼接会隐含的new一个StringBuilder去append
    //当a是常量的时候，add引用对应的字符串在编译期间就确定了，于是在编译的时期会把滴20行变成String add = "abc"
    int count = 100000;
    long l = System.nanoTime();
    for (int i = 0; i < count; i++) {
      String add = a + "b" + "c";
    }
    long l1 = System.nanoTime();
    for (int i = 0; i < count; i++) {
      String stringBuffer = new StringBuffer(a).append("b").append("c").toString();
    }
    long l2 = System.nanoTime();
    for (int i = 0; i < count; i++) {
      String stringBuilder = new StringBuilder(a).append("b").append("c").toString();
    }
    long l3 = System.nanoTime();
    for (int i = 0; i < count; i++) {
      String concat = a.concat("b").concat("c");
    }
    long l4 = System.nanoTime();
    System.out.println("concat       :" + (l4 - l3));
    System.out.println("stringBuilder:" + (l3 - l2));
    System.out.println("stringBuffer :" + (l2 - l1));
    System.out.println("add          :" + (l1 - l));
  }
}
