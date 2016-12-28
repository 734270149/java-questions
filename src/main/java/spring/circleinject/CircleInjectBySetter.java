package spring.circleinject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shiguang3 on 2016/12/28.
 */
public class CircleInjectBySetter {
  public static void main(String[] args) {
    //不报错
    new ClassPathXmlApplicationContext("spring/circleinject/setter.xml");

    //报错，手动禁止循环依赖
    //当bean不是singleton时，循环依赖也报错，因为不暴露ObjectFactory
    //原因在org.springframework.beans.factory.support.AbstractBeanFactory.java:301 if (mbd.isSingleton()) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
    context.setConfigLocation("spring/circleinject/setter.xml");
    context.setAllowCircularReferences(false);
    try {
      context.refresh();
    } catch (Exception e) {
      //org.springframework.beans.factory.BeanCurrentlyInCreationException
      e.getCause().getCause().printStackTrace();
    }
  }
}
