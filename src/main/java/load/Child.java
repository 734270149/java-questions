package load;

/**
 * Created by shiguang3 on 2017/2/8.
 */
class Child extends Parent {

  static Object o = new Object();

  static Parent p1 = new Parent();

  static {
    System.out.println("Child static{}");
  }

  static Parent p2 = new Parent();

  {
    System.out.println("Child {}");
  }

  Child() {
    System.out.println("Child Child()");
  }
}