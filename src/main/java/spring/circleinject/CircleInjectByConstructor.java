package spring.circleinject;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shiguang3 on 2016/12/28.
 */
public class CircleInjectByConstructor {
  public static void main(String[] args) {
    try {
      new ClassPathXmlApplicationContext("spring/circleinject/constructor.xml");
    } catch (BeansException e) {
      e.getCause().getCause().printStackTrace();
      //org.springframework.beans.factory.BeanCurrentlyInCreationException
    }
  }
}
