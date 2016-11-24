package sg;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dengshuangwei
 * Date: 14-12-12
 * Time: 上午11:38
 * To change this template use File | Settings | File Templates.
 */
public enum BizType {

    WAREHOUSEFEE((byte) 1, "仓储服务费"),
    BTC((byte) 2, "大件TC转运费"),
    STC((byte) 3, "小件TC转运费"),
    LOAD((byte) 4, "装卸费"),
    INTERNALDISTRIBUTION((byte) 5, "内配");


    //用于状态编号向状态名的转换
    private static Map<Byte, String> transferMap = new HashMap<Byte, String>() {
        {
            put(WAREHOUSEFEE.getCode(), WAREHOUSEFEE.getName());
            put(BTC.getCode(), BTC.getName());
            put(STC.getCode(), STC.getName());
            put(LOAD.getCode(), LOAD.getName());
            put(INTERNALDISTRIBUTION.getCode(), INTERNALDISTRIBUTION.getName());
        }
    };
    /**
     * 代码
     */
    private Byte code;
    /**
     * 名称
     */
    private String name;

    private BizType(Byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 用于状态编号向状态名的转换
     *
     * @param code
     * @return
     */
    public static String getNameByCode(Byte code) {
        return transferMap.get(code);
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
