package collection;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by shiguang3 on 2016/9/9.
 */
public class Key extends AbstractCollection<Object> {

  @Override
  public Iterator<Object> iterator() {
    ArrayList<Object> objects = new ArrayList<Object>();
    objects.add(new Object());
    objects.add(new Object());
    objects.add(new Object());
    return objects.iterator();
  }

  @Override
  public int size() {
    return 2;
  }
}
