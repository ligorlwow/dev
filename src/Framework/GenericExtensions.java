package Framework;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericExtensions {

    public static Type getGenericClass(Class<?> superclass) {
        return ((ParameterizedType) superclass.getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public static Object getInstance(Type type) {
        try {
            return ((Class) type).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot get object instance");
        }
    }
}
