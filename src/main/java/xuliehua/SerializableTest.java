package xuliehua;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by shiguang3 on 2016/12/6.
 */
public class SerializableTest implements Serializable {

  private Object writeReplace() throws ObjectStreamException {
    System.out.println("writeReplace invoked");
    return this;
  }

  private Object readResolve() throws ObjectStreamException {
    System.out.println("readResolve invoked");
    return this;
  }

  private void writeObject(java.io.ObjectOutputStream out) throws IOException {
    System.out.println("writeObject invoked");
  }

  private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
    System.out.println("readObject invoked");
  }

  private void readObjectNoData() throws ObjectStreamException {
    System.out.println("readObjectNoData invoked");
  }
}
