package xuliehua;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

/**
 * Created by shiguang3 on 2016/12/6.
 */
public class ExternalizableTest implements Externalizable {

  private Object writeReplace() throws ObjectStreamException {
    System.out.println("writeReplace invoked");
    return this;
  }

  private Object readResolve() throws ObjectStreamException {
    System.out.println("readResolve invoked");
    return this;
  }

  public void writeExternal(ObjectOutput out) throws IOException {
    System.out.println("writeExternal invoked");
  }

  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    System.out.println("readExternal invoked");
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
