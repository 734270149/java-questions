package fenpai;

/**
 * 单分派：根据一个宗量的类型进行方法的选择
 * 多分派：根据多于一个宗量的类型对方法的选择
 * Java是一种动态单分派，静态多分派的语言
 * Created by shiguang3 on 2016/12/5.
 */
public class Main {

  public static void main(String[] args) {
    Father father = new Father();
    Son son = new Son();
    Grandson grandson = new Grandson();
    Father fatherSon = new Son();
    Father fatherGrandson = new Grandson();

    print(father);
    print(son);
    print(grandson);
    print(fatherSon);
    print(fatherGrandson);
  }

  private static void print(Father param) {
    System.out.println("接收参数Father：" + param.getName());
  }

  private static void print(Son param) {
    System.out.println("接收参数Son：" + param.getName());
  }

  private static class Father {

    protected String getName() {
      return "Father";
    }
  }

  private static class Son extends Father {

    @Override
    protected String getName() {
      return "Son";
    }
  }

  private static class Grandson extends Son {

    @Override
    protected String getName() {
      return "Grandson";
    }
  }
}
