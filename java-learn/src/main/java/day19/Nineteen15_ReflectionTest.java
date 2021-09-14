package src.main.java.day19;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Nineteen15_ReflectionTest {
    //@Test表示测试类，可以单独运行
    @Test
    public void testGenericAndReflection() {
        //PersonDao对象，继承Dao，是Person类型对象
        Nineteen11_PersonDao pDao = new Nineteen11_PersonDao();
        Nineteen9_Person entity = new Nineteen9_Person();
        pDao.save(entity);
        Nineteen9_Person result = pDao.get(1);
    }

    @Test
    public void testgetSuperClassGenricType(){
        //EmployeeDao继承BaseDao，参数是Employee和String类型
        Class clazz = Nineteen14_EmployeeDao.class;
        //class Employee,获取参数类型第一个类型
        Class argClass = getSuperClassGenricType(clazz, 0);
        System.out.println(argClass);
        //class String,获取参数类型第二个类型
        argClass = getSuperClassGenricType(clazz, 1);
        System.out.println(argClass);
    }

    /**
     * 通过反射获得定义Class时声明的父类的泛型参数的类型
     * 如：public EmployeeDao extends BaseDao<Employee,String>
     * @param clazz：子类对应的Class对象
     * @param index：子类继承父类时传入的泛型的索引，从0开始
     */
    public static Class getSuperClassGenricType(Class clazz, int index) {
        //获取子类的带泛型参数的父类：BaseDao<Employee,String>
        Type genType = clazz.getGenericSuperclass();
        //获取具体的泛型参数，如果genType是带参数的类型，强制转换
        if (!(genType instanceof ParameterizedType))
            return Object.class;
        //返回一个表示此类型的实际类型参数的数组 Type对象：{Employee,String}
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0)
            return Object.class;
        if (!(params[index] instanceof Class))
            return Object.class;
        return (Class) params[index];
    }
}