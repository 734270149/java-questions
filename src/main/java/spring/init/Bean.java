package spring.init;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by shiguang3 on 2016/12/28.
 */
public class Bean implements InitializingBean {
  public void afterPropertiesSet() throws Exception {
    System.out.println("Bean afterPropertiesSet");
  }

  public void init() {
    System.out.println("Bean init");
  }
}
