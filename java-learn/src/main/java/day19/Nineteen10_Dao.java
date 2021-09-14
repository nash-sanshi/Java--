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

        //��ȡDao����ĸ��ࣺDao
        Class<?> tClass2 = this.getClass().getSuperclass();
        System.out.println(tClass2);//class Dao

        //��ȡDao����Ĵ����Ͳ����ĸ��� ��Dao<Person>
        Type type = this.getClass().getGenericSuperclass();
        System.out.println(type);//Dao<Person>
        //��ȡ����ķ��Ͳ��������type�Ǵ����������ͣ�ǿ��ת��
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            //����һ����ʾ�����͵�ʵ�����Ͳ��������� Type����Person
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
