package spring.init;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shiguang3 on 2016/12/28.
 */
public class InitMethodTest {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/init/spring.xml");
    context.registerShutdownHook();
    //先执行afterPropertiesSet再执行init-method执行的初始化方法
    //原因在org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods()
  }
}
