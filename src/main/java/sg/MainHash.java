package sg;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by shiguang3 on 2016/4/18.
 */
public class MainHash {

    private static final String DOU_HAO = ",";

    public static void main(String[] args) {
        System.out.println(fnv1Hash(""));
        TreeMap<Long, Integer> treeMap = new TreeMap<Long, Integer>();
        for (int i = 0; i < 10; i++) {
            String table = "storage_price_detail_" + i;
            for (int j = 0; j < 100; j++) {
                treeMap.put(hash(table + "&&" + j), i);
            }
        }
        Map.Entry<Long, Integer> firstEntry = treeMap.firstEntry();
        int first = firstEntry.getValue();
        int[] count = new int[10];
        StringBuilder builder = new StringBuilder(15);
        for (int i = 0; i < 5; i++) {//库房类型5
            for (int j = 0; j < 2; j++) {//订单来源2
                for (int k = 0; k < 3; k++) {//业务类型3
                    for (int l = 0; l < 1000; l++) {//sku三级分类1000
                        for (int m = 0; m < 6; m++) {//件型6
                            for (int n = 0; n < 3; n++) {//销售属性3
                                for (int o = 0; o < 4; o++) {//温层属性4
                                    for (int p = 0; p < 10; p++) {//动作名称10
                                        builder.setLength(0);
                                        Map.Entry<Long, Integer> entry = treeMap.ceilingEntry(hash(builder.append(i).append(DOU_HAO).append(j).append(DOU_HAO)
                                                .append(k).append(DOU_HAO).append(l).append(DOU_HAO)
                                                .append(m).append(DOU_HAO).append(n).append(DOU_HAO)
                                                .append(o).append(DOU_HAO).append(p).toString()));
                                        if (entry == null) {
                                            count[first]++;
                                        } else {
                                            count[entry.getValue()]++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }
        int min = 0;
        int max = 0;
        for (int i = 1; i < 10; i++) {
            if (count[i] > count[max]) {
                max = i;
            }
            if (count[i] < count[min]) {
                min = i;
            }
        }
        System.out.println("极差：" + (count[max] - count[min]));
    }

    private static long hash(String key) {
        //总数21600000;
        return fnv1Hash(key);//53,3113
//        return murMurHash(key);//60,5162
//        return md5HashingAlg(key);//58,8254
    }

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
     *
     * @param str
     * @return
     */
    private static int fnv1Hash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return (hash ^ (hash >> 31)) - (hash >> 31);
    }

    /**
     * MurMurHash算法，是非加密HASH算法，性能很高，
     * 比传统的CRC32,MD5，SHA-1（这两个算法都是加密HASH算法，复杂度本身就很高，带来的性能上的损害也不可避免）
     * 等HASH算法要快很多，而且据说这个算法的碰撞率很低.
     * http://murmurhash.googlepages.com/
     */
    private static Long murMurHash(String key) {

        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        int seed = 0x1234ABCD;

        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);

        long m = 0xc6a4a7935bd1e995L;
        int r = 47;

        long h = seed ^ (buf.remaining() * m);

        long k;
        while (buf.remaining() >= 8) {
            k = buf.getLong();

            k *= m;
            k ^= k >>> r;
            k *= m;

            h ^= k;
            h *= m;
        }

        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(
                    ByteOrder.LITTLE_ENDIAN);
            // for big-endian version, do this first:
            // finish.position(8-buf.remaining());
            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }

        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;

        buf.order(byteOrder);
        return h;
    }

    /**
     * Calculates the ketama hash value for a string
     *
     * @return
     */
    public static long md5HashingAlg(String key) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(key.getBytes());
            byte[] bKey = md5.digest();
            return ((long) (bKey[3] & 0xFF) << 24) | ((long) (bKey[2] & 0xFF) << 16) | ((long) (bKey[1] & 0xFF) << 8) | (long) (bKey[0] & 0xFF);
        } catch (Exception e) {
            return (long) -1;
        }
    }
}
