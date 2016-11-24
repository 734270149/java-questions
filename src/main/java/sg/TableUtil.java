package sg;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by shiguang3 on 2016/5/10.
 */
public final class TableUtil {

    private static final TreeMap<Integer, String> waresprice_seller_dimensions = new TreeMap<Integer, String>();
    private static final TreeMap<Integer, String> waresprice_seller_ladder = new TreeMap<Integer, String>();
    private static final TreeMap<Integer, String> waresprice_standard_dimensions = new TreeMap<Integer, String>();
    private static final TreeMap<Integer, String> waresprice_standard_ladder = new TreeMap<Integer, String>();
    private static final String JOIN = "&&";

    static {
        for (int i = 0; i < 10; i++) {
            String table = "waresprice_seller_dimensions_" + i;
            for (int j = 0; j < 100; j++) {
                waresprice_seller_dimensions.put(fnv1Hash(table + JOIN + j), table);
            }
        }
        for (int i = 0; i < 10; i++) {
            String table = "waresprice_seller_ladder_" + i;
            for (int j = 0; j < 100; j++) {
                waresprice_seller_ladder.put(fnv1Hash(table + JOIN + j), table);
            }
        }
        for (int i = 0; i < 10; i++) {
            String table = "waresprice_standard_dimensions_" + i;
            for (int j = 0; j < 100; j++) {
                waresprice_standard_dimensions.put(fnv1Hash(table + JOIN + j), table);
            }
        }
        for (int i = 0; i < 10; i++) {
            String table = "waresprice_standard_ladder_" + i;
            for (int j = 0; j < 100; j++) {
                waresprice_standard_ladder.put(fnv1Hash(table + JOIN + j), table);
            }
        }
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
     * 获取表waresprice_seller_dimensions
     *
     * @param param
     * @return
     */
    public static String getSellerDimensionsTable(String param) {
        Map.Entry<Integer, String> entry = waresprice_seller_dimensions.ceilingEntry(fnv1Hash(param));
        if (entry == null) {
            return waresprice_seller_dimensions.firstEntry().getValue();
        } else {
            return entry.getValue();
        }
    }

    /**
     * 获取表waresprice_seller_ladder
     *
     * @param param
     * @return
     */
    public static String getSellerLadderTable(String param) {
        Map.Entry<Integer, String> entry = waresprice_seller_ladder.ceilingEntry(fnv1Hash(param));
        if (entry == null) {
            return waresprice_seller_ladder.firstEntry().getValue();
        } else {
            return entry.getValue();
        }
    }

    /**
     * 获取表waresprice_standard_dimensions
     *
     * @param param
     * @return
     */
    public static String getStandardDimensionsTable(String param) {
        Map.Entry<Integer, String> entry = waresprice_standard_dimensions.ceilingEntry(fnv1Hash(param));
        if (entry == null) {
            return waresprice_standard_dimensions.firstEntry().getValue();
        } else {
            return entry.getValue();
        }
    }

    /**
     * 获取表waresprice_standard_ladder
     *
     * @param param
     * @return
     */
    public static String getStandardLadderTable(String param) {
        Map.Entry<Integer, String> entry = waresprice_standard_ladder.ceilingEntry(fnv1Hash(param));
        if (entry == null) {
            return waresprice_standard_ladder.firstEntry().getValue();
        } else {
            return entry.getValue();
        }
    }
}
