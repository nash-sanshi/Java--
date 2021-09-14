package src.main.java.JDBC1;

import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class JDBCTest {
    /**
     * Driver��һ���ӿڣ����ݿ⳧�̱����ṩʵ�ֵĽӿڣ��ܴ����л�ȡ���ݿ����ӣ�
     * ����ͨ��Driver��ʵ��������ȡ���ݿ�����
     * 1������mysql������
     * 2���ڵ�ǰ��Ŀ���½�libĿ¼
     * 3����mysql...jar���Ƶ�libĿ¼��
     * 4���Ҽ�build-path��add to build path���뵽��·����
     */
    @Test
    public void testDriver() throws SQLException {
        //����һ��Driverʵ�������
        Driver driver = new com.mysql.jdbc.Driver();
        //׼���������ݿ�Ļ�����Ϣ
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        Properties properties = new Properties();
        properties.put("user","root");
        properties.put("password","123456");
        //����driver�ӿڵ�connect��ȡ���ݿ�����
        Connection connection = driver.connect(url,properties);
        System.out.println(connection);
    }
    /**
     * ��дһ��ͨ�÷������ڲ��޸�Դ���������£����Ի�ȡ�κ����ݿ������
     * ��������������ݿ�����driverʵ�����ȫ������url��user��password����һ��
     * �����ļ��У�ͨ���޸������ļ��ķ�ʽʵ�ֺ;�������ݿ���н���
     */
    public Connection getConnection() throws Exception {
        String driverClass = null;
        String JdbcUrl = null;
        String user = null;
        String password = null;
        //��ȡ��·���µ�jdbc.properties�ļ�
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        driverClass = properties.getProperty("driver");
        JdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        //System.out.println(password);
        //��������
        Driver driver = (Driver) Class.forName(driverClass).newInstance();
        Properties info = new Properties();
        info.put("user", user);
        info.put("password", password);
        return driver.connect(JdbcUrl, info);
    }

    @Test
    public void testGetConnection() throws Exception {
        System.out.println(getConnection());
        System.out.println(JDBCTools.getConnection());
    }

    /**
     * DriverManager�������Ĺ�����
     */
    @Test
    public void testDriverManager() throws Exception {
        //1��׼���������ݿ��4���ַ���
        String driverClass = null;
        String JdbcUrl = null;
        String user = null;
        String password = null;
        //��ȡ��·���µ�jdbc.properties�ļ�
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        driverClass = properties.getProperty("driver");
        JdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        //2����������
        //Driver driver = (Driver) Class.forName(driverClass).newInstance();
        Class.forName(driverClass);
        //3��ͨ��DriverManager��getConnection������ȡ���ݿ�����
        Connection connection = DriverManager.getConnection(JdbcUrl,user,password);
        System.out.println(connection);
    }

    /**
     * ͨ��JDBC��ָ�������ݱ��в���һ����¼
     * 1��Statement��ִ��SQL���Ķ���
     * a��ͨ��connection.createStatement()������ȡ
     * b��ͨ��executeUpdate(sql)����ִ��SQL���
     * c�������SQL������insert��update��delete������select
     * 2��Connection��Statement����Ӧ�ó�������ݿ��������������Դ��
     * ʹ�ú�һ��Ҫ�ر�,��Ҫ��finally�йر�Connection��Statement����
     * 3���رյ�˳���ǣ��ȹرպ��ȡ�ģ����ȹر�Statement����ر�Connection
     */
    @Test
    public void testStatement() {
        //1����ȡ���ݿ�����
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCTools.getConnection();
            //2��׼�������SQL���
            String sql = "INSERT into customers(name,email,birth) VALUES('xyz','xyz@ntrj.cn'" +
                    ",'1980-12-12');";
            //3��ִ�в���
            //a����ȡ����SQL����statement���󣺵���connection��createstatement������ȡ
            statement = connection.createStatement();
            //b������statement�����executeUpdate(sql)ִ��SQL�����в���
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4���ر�statement����
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            //5���ر�����
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * ResultSet:���������װ��ʹ��JDBC���в�ѯ�Ľ��
     * 1������Statement�����executeQuery(sql)���Եõ������
     * 2��ResultSet���ص�ʵ���Ͼ���һ�����ݱ���һ��ָ��ָ�����ݱ�ĵ�һ�е�ǰ��
     * ���Ե���next()���������һ���Ƿ���Ч������Ч�÷�������true����ָ�����ƣ�
     * �൱��Iterator�����hasNext��next�����Ľ���塣
     * 3����ָ���λ��һ��ʱ������ͨ������getxxx(index)����getxxx(columnName)��ȡÿһ�е�ֵ
     * 4��ResultSet��ȻҲ��Ҫ���йر�
     */
    @Test
    public void testResultSet()  {
        //��ȡcustomers���ݱ�ļ�¼������ӡ
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1����ȡConnection
            connection = JDBCTools.getConnection();
            //2����ȡStatement
            statement = connection.createStatement();
            //3��׼��SQL
            String sql = "select  id,name,email,birth from customers;";
            //4��ִ�в�ѯ���õ�ResultSet
            resultSet = statement.executeQuery(sql);
            //5������ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);
                System.out.println(id);
                System.out.println(name);
                System.out.println(email);
                System.out.println(birth);
            }
            //6���ر����ݿ���Դ
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(resultSet,statement,connection);
        }
    }

    /**
     * 1�������ݱ����һ��student��¼
     * a���½�һ��student����Ӧexamstudent���ݱ�
     * class Student{
     *     int flowId;
     *     int type;
     *     String idCard;
     *     String examCard;
     *     String StudentName;
     *     String location;
     *     int grade;
     * }
     * b���½�һ��������void addStudent(Student s)������Student������뵽���ݿ�
     * addStudent(Student s){
     *     String sql = "insert into examstudent values(��s.get*��)";
     *     //����JDBCTools���update(sql)����ִ�в������
     * c���ڲ��Է���testAddStudent()��
     *      1����ȡ�ӿ���̨�����student
     *      Student s = getStudentFromConsole()
     *      2������addStudent(Student s)����ִ�в������
     * }
     * 2��PreparedStatement
     * a��ΪʲôҪ��PreparedStatement��ʹ��Statement��Ҫ����ƴдSQL��䣬���׳���
     * b��String sql = "insert into examstudent valuse(?,?,?)"
     * c��ʹ��PreparedStatement
     *      �ٴ���PreparedStatement
     *      PreparedStatement ps = conn.preparedStatement(sql);
     *      �ڵ���PreparedStatement��setxxx(int index,object val)����ռλ����ֵ
     *      ��ִ��SQL���executeQuery()��executeUpdate()��ע�⣺ִ��ʱ������Ҫ����sql���
     */
    public void addStudent1(Student s) {
        //׼��һ��sql���
        //insert into examstudent values( 20,5,'1122343','2233444','zhangsan','nantong',20)
        String sql = "insert into examstudent values("
                + s.getFlowId() + ","
                + s.getType() + ",'"
                + s.getIdCard() + "','"
                + s.getExamCard() + "','"
                + s.getStudentName() + "','"
                + s.getLocation() + "',"
                + s.getGrade() +")";
        //ƴ�ӵ�SQL��ӡ�����Ƿ���ȷ�������Ժ�ʹ��PreparedStatement��ƴ��
        // System.out.println(sql);
        //����JDBCTools���update(sql)����ִ�в������
        //statement������������Ҫƴ��SQL���Ƚ��鷳
        JDBCTools.update(sql);
    }

    public void addStudent2(Student student) {
        //preparedstatement���ɱ����������Ҫƴ��SQL
        String sql = "insert into examstudent(flowid,type,idcard,examcard,studentname," +
                "location,grade) values(?,?,?,?,?,?,?)";
        JDBCTools.update(sql, student.getFlowId(), student.getType(), student.getIdCard()
                , student.getExamCard(), student.getStudentName(), student.getLocation(),
                student.getGrade());
    }

    @Test
    public void testAddNewStudent() {
        Student student = getStudentFromConsole();
        addStudent1(student);
    }

    @Test
    public void testAddNewStudent2() {
        Student student = getStudentFromConsole();
        addStudent2(student);
    }

    /**
     * �ӿ���̨����ѧ������Ϣ
     */
    private Student getStudentFromConsole() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        System.out.print("FlowId:");
        student.setFlowId(scanner.nextInt());
        System.out.print("Type:");
        student.setType(scanner.nextInt());
        System.out.print("IdCard:");
        student.setIdCard(scanner.next());
        System.out.print("ExamCard:");
        student.setExamCard(scanner.next());
        System.out.print("StudentName:");
        student.setStudentName(scanner.next());
        System.out.print("Location:");
        student.setLocation(scanner.next());
        System.out.print("Grade:");
        student.setGrade(scanner.nextInt());
        return student;
    }

    @Test
    public void testGetStudent() {
        //1���õ���ѯ������
        int searchType = getSearchTypeFromConsole();
        //2�������ѯѧ����Ϣ
        Student student = searchStudent(searchType);
        //3����ӡѧ����Ϣ
        printStudent(student);
    }

    /**
     * ��ӡѧ����Ϣ����ѧ�����ڣ����ӡ�������Ϣ���������ڣ���ӡ���޴���
     * @param student
     */
    private void printStudent(Student student) {
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("���޴���");
        }
    }

    /**
     * �����ѯѧ����Ϣ������һ��student�����������ڣ��򷵻�null
     * @param searchType��1 or 2
     * @return
     */
    private Student searchStudent(int searchType) {
        String sql = "select flowid,type,idcard,examcard,studentname,location,grade" +
                " from examstudent where ";
        Scanner scanner = new Scanner(System.in);
        //1�����������searchType��ʾ�û�������Ϣ
        //��searchTypeΪ1����ʾ�����������֤�š�Ϊ2����ʾ��������׼��֤��
        //2������searchTypeȷ��SQL
        if (searchType == 2) {
            System.out.println("������׼��֤�ţ�");
            String examCard = scanner.next();
            sql = sql + " examcard = '" + examCard + "'";
        } else {
            System.out.println("���������֤�ţ�");
            String idCard = scanner.next();
            sql = sql + " idcard = '" + idCard + "'";
        } 
        //3��ִ�в�ѯ
        Student student = getStudent(sql);
        //4�������ڲ�ѯ������ѽ����װΪһ��student����
        return  student;
    }

    /**
     * ���ݴ����sql����student����
     * @param sql
     * @return
     */
    private Student getStudent(String sql) {
        Student student = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCTools.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                student = new Student(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(resultSet,statement,connection);
        }
        return student;
    }

    /**
     * �ӿ���̨����һ��֤�飬ȷ��Ҫ��ѯ������
     * @return 1�������֤��ѯ 2����׼��֤��ѯ��������Ч������ʾ�û���������
     */
    private int getSearchTypeFromConsole() {
        System.out.println("�������ѯ���ͣ�1.�����֤��ѯ��2.��׼��֤��ѯ");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        if (type != 1 && type != 2) {
            System.out.println("�����������������");
            throw new RuntimeException();
        }
        return type;
    }

    @Test
    public void testPreparedStatement() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCTools.getConnection();
            String sql = "insert into customers(name,email,birth) values(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "ntrj");
            preparedStatement.setString(2, "dfbz@ntrj.com");
            preparedStatement.setDate(3,new Date(new java.util.Date().getTime()));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(preparedStatement,connection);
        }
    }

    /**
     * sqlע��
     */
    @Test
    public void testSQLInjection() {
        String username = "a' or password=";
        String password = " or '1' = '1";
        String sql = "select * from users where username = '" + username + "' " +
                "and password = '" + password + "'";
        System.out.println(sql);
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCTools.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                System.out.println("��¼�ɹ�");
            } else {
                System.out.println("�û��������벻ƥ������û���������");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(resultSet,statement,connection);
        }
    }

    /**
     * ʹ��PreparedStatement����Ч�Ľ��SQLע�������
     */
    @Test
    public void testSQLInjection2() {
        String username = "a' or password=";
        String password = " or '1' = '1";
        String sql = "select * from users where username = ? and password = ?";
        System.out.println(sql);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("��¼�ɹ�");
            } else {
                System.out.println("�û��������벻ƥ������û���������");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(resultSet,preparedStatement,connection);
        }
    }

    private Student getStudent(String sql,Object...args) {
        Student student = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = new Student();
                student.setFlowId(resultSet.getInt(1));
                student.setType(resultSet.getInt(2));
                student.setIdCard(resultSet.getString(3));
                student.setExamCard(resultSet.getString(4));
                student.setStudentName(resultSet.getString(5));
                student.setLocation(resultSet.getString(6));
                student.setGrade(resultSet.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(resultSet,preparedStatement,connection);
        }
        return student;
    }

    private Customer getCustomer(String sql, Object...args) {
        Customer customer = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getInt(1));
                customer.setName(resultSet.getString(2));
                customer.setEmail(resultSet.getString(3));
                customer.setBirth(resultSet.getDate(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(resultSet,preparedStatement,connection);
        }
        return customer;
    }

    public <T> T get(Class<T> tClass,String sql, Object... args) {
        T entity = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            //1���õ�ResultSet����
            resultSet = preparedStatement.executeQuery();
            //2���õ�ResultSetMetaData����
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            //3������һ��Map<String,Object>���󣬼���SQL��ѯ���еı�����ֵ���е�ֵ
            Map<String, Object> values = new HashMap<>();
            //4����������������ResultSetMetaData���3��Ӧ��Map����
            if (resultSet.next()) {
                for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                    String columnLabel = resultSetMetaData.getColumnLabel(i + 1);
                    Object columnValue = resultSet.getObject(i + 1);
                    values.put(columnLabel, columnValue);
                }
            }
            //5����Map��Ϊ�գ����÷��䴴��tClass��Ӧ�Ķ���
            if (values.size() > 0) {
                entity = tClass.newInstance();
                //����Map�������÷���ΪClass�����Ӧ�����Ը�ֵ
                for (Map.Entry<String,Object> entry : values.entrySet()) {
                    String filedName = entry.getKey();
                    Object filedValue = entry.getValue();
                    ReflectionUtils.setFieldValue(entity,filedName,filedValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(resultSet,preparedStatement,connection);
        }
        return entity;
    }

    @Test
    public void testGet() {
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer customer = get(Customer.class, sql, 2);
        System.out.println(customer);
        sql = "select flowid flowId,type,idcard idCard,examcard examCard," +
                "studentname studentName,location,grade from examstudent where flowid = ?";
        Student student = get(Student.class, sql, 4);
        System.out.println(student);
    }

    /**
     * ResultSetMetaData
     * 1��������ResultSet��Ԫ���ݶ��󣬼����п��Ի�ȡ����������ж����У�������ʲô
     * 2�����ʹ��
     *      a���õ�ResultSetMetaData���󣬵���ResultSet��getMetaData����
     *      b��ResultSetMetaData����Щ���õķ���
     *          int getColumnCount��SQL��������Щ��
     *          String getColumnLable(int column)����ȡָ���еı���������������1��ʼ
     */
    @Test
    public void testResultSetMetaData() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select flowid flowId,type,idcard idCard,examcard examCard," +
                    "studentname studentName,location,grade from examstudent where flowid = ?";
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 4);
            resultSet = preparedStatement.executeQuery();
            //1���õ�ResultSetMetaData����
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            Map<String, Object> values = new HashMap<>();
            while (resultSet.next()) {
                //2����ӡÿһ�е�����
                for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                    String columnLabel = resultSetMetaData.getColumnLabel(i + 1);
                    Object columnValue = resultSet.getObject(columnLabel);
                    values.put(columnLabel, columnValue);
                }
            }
            System.out.println(values);
            Class<Student> clazz = Student.class;
            Object object = clazz.newInstance();
            for (Map.Entry<String,Object> entry : values.entrySet()) {
                String filedName = entry.getKey();
                Object filedValue = entry.getValue();
                //System.out.println(filedName + ":" + filedValue);
                ReflectionUtils.setFieldValue(object,filedName,filedValue);
            }
            System.out.println(object);
            //System.out.println(values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(resultSet,preparedStatement,connection);
        }
    }
}
