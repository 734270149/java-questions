package compress;

/**
 * Created by shiguang3 on 2016/8/23.
 */
public class SG {

  private String s;

  public SG() {
  }

  public SG(String s) {
    this.s = s;
  }

  public String getS() {
    return s;
  }

  public void setS(String s) {
    this.s = s;
  }

  @Override
  public String toString() {
    return s + "," + s;
  }
}
