package src.main.java.JDBC2;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
    @Test
    public void testSetProperty() throws InvocationTargetException, IllegalAccessException {
        Object object = new Student();
        System.out.println(object);
        BeanUtils.setProperty(object,"idCard","1111111");
        System.out.println(object);
    }

    @Test
    public void testGetProperty() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Object object = new Student();
        System.out.println(object);
        BeanUtils.setProperty(object,"idCard","1111111");
        System.out.println(object);
        Object val = BeanUtils.getProperty(object, "idCard");
        System.out.println(val);
    }
}
