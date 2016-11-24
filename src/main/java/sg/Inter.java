package sg;

import java.io.Serializable;
import java.util.RandomAccess;

interface Inter extends Serializable, Iterable, RandomAccess {
    void test();
}
