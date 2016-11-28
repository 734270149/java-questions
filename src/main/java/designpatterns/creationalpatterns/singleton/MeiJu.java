package designpatterns.creationalpatterns.singleton;

/**
 * 枚举式
 * 不需要任何加锁校验等步骤，而且还能防止反序列化导致重新创建新的对象。
 * 在《Effective Java》中，第三条的最后一句说：
 * a single-element enum type is the best way to implement a singleton
 * Created by shiguang3 on 2016/11/28.
 */
public enum MeiJu {
  INSTANCE
}
