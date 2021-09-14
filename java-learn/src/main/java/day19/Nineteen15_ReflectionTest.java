package src.main.java.day19;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Nineteen15_ReflectionTest {
    //@Test��ʾ�����࣬���Ե�������
    @Test
    public void testGenericAndReflection() {
        //PersonDao���󣬼̳�Dao����Person���Ͷ���
        Nineteen11_PersonDao pDao = new Nineteen11_PersonDao();
        Nineteen9_Person entity = new Nineteen9_Person();
        pDao.save(entity);
        Nineteen9_Person result = pDao.get(1);
    }

    @Test
    public void testgetSuperClassGenricType(){
        //EmployeeDao�̳�BaseDao��������Employee��String����
        Class clazz = Nineteen14_EmployeeDao.class;
        //class Employee,��ȡ�������͵�һ������
        Class argClass = getSuperClassGenricType(clazz, 0);
        System.out.println(argClass);
        //class String,��ȡ�������͵ڶ�������
        argClass = getSuperClassGenricType(clazz, 1);
        System.out.println(argClass);
    }

    /**
     * ͨ�������ö���Classʱ�����ĸ���ķ��Ͳ���������
     * �磺public EmployeeDao extends BaseDao<Employee,String>
     * @param clazz�������Ӧ��Class����
     * @param index������̳и���ʱ����ķ��͵���������0��ʼ
     */
    public static Class getSuperClassGenricType(Class clazz, int index) {
        //��ȡ����Ĵ����Ͳ����ĸ��ࣺBaseDao<Employee,String>
        Type genType = clazz.getGenericSuperclass();
        //��ȡ����ķ��Ͳ��������genType�Ǵ����������ͣ�ǿ��ת��
        if (!(genType instanceof ParameterizedType))
            return Object.class;
        //����һ����ʾ�����͵�ʵ�����Ͳ��������� Type����{Employee,String}
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0)
            return Object.class;
        if (!(params[index] instanceof Class))
            return Object.class;
        return (Class) params[index];
    }
}