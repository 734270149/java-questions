package sg;

/**
 * Created by shiguang3 on 2016/5/10.
 */
public class TestTable {
    public static void main(String[] args) {
        long t1 = System.nanoTime();
        TableUtil.getSellerDimensionsTable("asdfa,sfasd,fasf,asd,as,das,");
        long t2 = System.nanoTime();
        TableUtil.getSellerLadderTable("opeui.;pr']uwetio[]jjladjalsjk");
        long t3 = System.nanoTime();
        TableUtil.getStandardDimensionsTable("opeui.;pr']uweti1231078sdfdjalsjk");
        long t4 = System.nanoTime();
        TableUtil.getStandardLadderTable("opeui.;pr']uwetio[]sda456646++alsjk");
        long t5 = System.nanoTime();
        System.out.println(t2 - t1);
        System.out.println(t3 - t2);
        System.out.println(t4 - t3);
        System.out.println(t5 - t4);
        while (true) {

        }
    }
}
