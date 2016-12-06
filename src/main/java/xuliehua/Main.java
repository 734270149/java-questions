package xuliehua;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化测试
 * 坑1：Externalizable序列化，必须保证类有public修饰的无参构造函数，否则会报错：
 * java.io.InvalidClassException: xuliehua.ExternalizableTest; no valid constructor.
 * 坑2：Externalizable序列化，必须手动在两个External方法里写入和读取要序列化的属性。
 * 坑3：Externalizable序列化，会执行两个External方法，不执行两个Object方法。
 * 坑4：readObjectNoData()使用场景，参考stackoverflow连接如下：(intellij里ctrl+左键即可打开连接)
 * http://stackoverflow.com/questions/7445217/java-when-to-add-readobjectnodata-during-serialization
 * 简言之：先把某个类序列化到文件里，然后再把该类添加一个父类，然后从文件里反序列化该类，
 * 此时反序列化会调用父类的readObjectNoData()去给父类里的属性初始化。
 * Created by shiguang3 on 2016/12/6.
 */
public class Main {

  public static void main(String[] args) throws Exception {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(bos);
    os.writeObject(new SerializableTest());
    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
    ObjectInputStream is = new ObjectInputStream(bis);
    is.readObject();
    System.out.println("==============");
    ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
    ObjectOutputStream os1 = new ObjectOutputStream(bos1);
    os1.writeObject(new ExternalizableTest());
    ByteArrayInputStream bis1 = new ByteArrayInputStream(bos1.toByteArray());
    ObjectInputStream is1 = new ObjectInputStream(bis1);
    is1.readObject();
  }
}
