package spring.dependson;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by shiguang3 on 2016/12/28.
 */
public class DependsBean implements InitializingBean, DisposableBean {
  public void destroy() throws Exception {
    System.out.println("DependsBean destroy");
  }

  public void afterPropertiesSet() throws Exception {
    System.out.println("DependsBean afterPropertiesSet");
  }
}
