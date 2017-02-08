package load;

/**
 * Created by shiguang3 on 2017/2/8.
 */
class Parent {

  static {
    System.out.println("Parent static{}");
  }

  {
    System.out.println("Parent {}");
  }

  Parent() {
    System.out.println("Parent Parent()");
  }
}