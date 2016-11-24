package Jedis;

import java.util.Map;

import redis.clients.jedis.Jedis;

/**
 * Created by shiguang3 on 2016/9/12.
 */
public class JedisMain {

  public static void main(String[] args) {
    Jedis jedis = new Jedis("127.0.0.1");
    long l = System.currentTimeMillis();
//    for (int i = 0; i < 2000000; i++) {
//      String s = Integer.toString(i);
//      jedis.hset("sg", s, s);
//    }
    long l2 = System.currentTimeMillis();
    Map<String, String> sg = jedis.hgetAll("sg");
    long l3 = System.currentTimeMillis();
    System.out.println(sg.size());
    System.out.println(sg.getClass());
    System.out.println("hset:" + (l2 - l));
    System.out.println("hgetAll:" + (l3 - l2));
  }
}
