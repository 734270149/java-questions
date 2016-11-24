package sg;

/**
 * Created by shiguang3 on 2016/8/17.
 */
public enum abstractEnum {
    A {
        @Override
        void get() {
        }
    };

    abstract void get();
}
