package spring.circleinject;

/**
 * Created by shiguang3 on 2016/12/28.
 */
public class BeanB {
  private BeanA a;

  public BeanB() {
  }

  public BeanB(BeanA a) {
    this.a = a;
  }

  public BeanA getA() {
    return a;
  }

  public void setA(BeanA a) {
    this.a = a;
  }
}
