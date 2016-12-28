package spring.circleinject;

/**
 * Created by shiguang3 on 2016/12/28.
 */
public class BeanA {
  private BeanB b;

  public BeanA() {
  }

  public BeanA(BeanB b) {
    this.b = b;
  }

  public BeanB getB() {
    return b;
  }

  public void setB(BeanB b) {
    this.b = b;
  }
}
