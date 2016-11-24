package cuowu;

/**
 * Created by shiguang3 on 2016/9/27.
 */
public class Main {

  public static void main(String[] args) {
    Wrap wrap = new Wrap();
    Obj obj = new Obj();
    obj.setBool(true);
    wrap.setObj(obj);

    Obj obj1 = wrap.getObj();
    obj1.setBool(false);

    System.out.println(wrap.getObj().isBool());
  }
  private static final class Wrap {
    private Obj obj;
    public Obj getObj() {return obj;}
    public void setObj(Obj obj) {this.obj = obj;}
  }
  private static final class Obj {
    private boolean bool;
    public boolean isBool() {return bool;}
    public void setBool(boolean bool) {this.bool = bool;}
  }
}
