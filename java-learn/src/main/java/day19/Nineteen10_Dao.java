package src.main.java.day19;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class Nineteen10_Dao<T> {
    private Class<T> tClass;

    T get(Integer id){
        System.out.println(tClass);
        return null;
    }

    void save(T entity){

    }

    public Nineteen10_Dao() {
        System.out.println("Dao is costructing");
        System.out.println(this);//PersonDao
        System.out.println(this.getClass());//class PersonDao

        //获取Dao子类的父类：Dao
        Class<?> tClass2 = this.getClass().getSuperclass();
        System.out.println(tClass2);//class Dao

        //获取Dao子类的带泛型参数的父类 ：Dao<Person>
        Type type = this.getClass().getGenericSuperclass();
        System.out.println(type);//Dao<Person>
        //获取具体的泛型参数，如果type是带参数的类型，强制转换
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            //返回一个表示此类型的实际类型参数的数组 Type对象：Person
            System.out.println(Arrays.asList(parameterizedType.getActualTypeArguments()));
            Type[] args = parameterizedType.getActualTypeArguments();
            if (args != null && args.length > 0) {
                Type arg = args[0];
                //System.out.println(arg);
                if (arg instanceof Class) {
                    tClass = (Class<T>) arg;//Person
                }
            }
        }
    }
}
