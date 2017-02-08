package generic;

/**
 * Created by shiguang3 on 2017/2/8.
 */
class Generic<I> {
  I global() {
    return null;
  }

  <M> M method(Class<M> mClass) throws IllegalAccessException, InstantiationException {
    return mClass.newInstance();
  }
}