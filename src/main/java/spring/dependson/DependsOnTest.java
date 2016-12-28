package spring.dependson;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shiguang3 on 2016/12/28.
 */
public class DependsOnTest {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dependson/spring.xml");
    context.registerShutdownHook();
    //先初始化depend再初始化main，先销毁main，再销毁depend
  }
}
