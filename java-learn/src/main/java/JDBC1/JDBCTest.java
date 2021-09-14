package src.main.java.JDBC1;

import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class JDBCTest {
    /**
     * Driver是一个接口：数据库厂商必须提供实现的接口，能从其中获取数据库连接，
     * 可以通过Driver的实现类对象获取数据库连接
     * 1、加入mysql的驱动
     * 2、在当前项目下新建lib目录
     * 3、把mysql...jar复制到lib目录下
     * 4、右键build-path，add to build path加入到类路径下
     */
    @Test
    public void testDriver() throws SQLException {
        //创建一个Driver实现类对象
        Driver driver = new com.mysql.jdbc.Driver();
        //准备连接数据库的基本信息
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        Properties properties = new Properties();
        properties.put("user","root");
        properties.put("password","123456");
        //调用driver接口的connect获取数据库连接
        Connection connection = driver.connect(url,properties);
        System.out.println(connection);
    }
    /**
     * 编写一个通用方法，在不修改源程序的情况下，可以获取任何数据库的链接
     * 解决方案：把数据库驱动driver实现类的全类名，url，user，password放入一个
     * 配置文件中，通过修改配置文件的方式实现和具体的数据库进行解耦
     */
    public Connection getConnection() throws Exception {
        String driverClass = null;
        String JdbcUrl = null;
        String user = null;
        String password = null;
        //读取类路径下的jdbc.properties文件
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        driverClass = properties.getProperty("driver");
        JdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        //System.out.println(password);
        //加载驱动
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
     * DriverManager是驱动的管理类
     */
    @Test
    public void testDriverManager() throws Exception {
        //1、准备连接数据库的4个字符串
        String driverClass = null;
        String JdbcUrl = null;
        String user = null;
        String password = null;
        //读取类路径下的jdbc.properties文件
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        driverClass = properties.getProperty("driver");
        JdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        //2、加载驱动
        //Driver driver = (Driver) Class.forName(driverClass).newInstance();
        Class.forName(driverClass);
        //3、通过DriverManager的getConnection方法获取数据库连接
        Connection connection = DriverManager.getConnection(JdbcUrl,user,password);
        System.out.println(connection);
    }

    /**
     * 通过JDBC向指定的数据表中插入一条记录
     * 1、Statement：执行SQL语句的对象
     * a、通过connection.createStatement()方法获取
     * b、通过executeUpdate(sql)可以执行SQL语句
     * c、传入的SQL可以是insert，update，delete不能是select
     * 2、Connection，Statement都是应用程序和数据库服务器的连接资源，
     * 使用后一定要关闭,需要在finally中关闭Connection和Statement对象
     * 3、关闭的顺序是：先关闭后获取的，即先关闭Statement，后关闭Connection
     */
    @Test
    public void testStatement() {
        //1、获取数据库连接
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCTools.getConnection();
            //2、准备插入的SQL语句
            String sql = "INSERT into customers(name,email,birth) VALUES('xyz','xyz@ntrj.cn'" +
                    ",'1980-12-12');";
            //3、执行插入
            //a、获取操作SQL语句的statement对象：调用connection的createstatement方法获取
            statement = connection.createStatement();
            //b、调用statement对象的executeUpdate(sql)执行SQL语句进行插入
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4、关闭statement对象
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            //5、关闭连接
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * ResultSet:结果集，封装了使用JDBC进行查询的结果
     * 1、调用Statement对象的executeQuery(sql)可以得到结果集
     * 2、ResultSet返回的实际上就是一张数据表，有一个指针指向数据表的第一行的前面
     * 可以调用next()方法检测下一行是否有效，若有效该方法返回true，且指针下移，
     * 相当于Iterator对象的hasNext和next方法的结合体。
     * 3、当指针对位于一行时，可以通过调用getxxx(index)或者getxxx(columnName)获取每一列的值
     * 4、ResultSet当然也需要进行关闭
     */
    @Test
    public void testResultSet()  {
        //获取customers数据表的记录，并打印
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1、获取Connection
            connection = JDBCTools.getConnection();
            //2、获取Statement
            statement = connection.createStatement();
            //3、准备SQL
            String sql = "select  id,name,email,birth from customers;";
            //4、执行查询，得到ResultSet
            resultSet = statement.executeQuery(sql);
            //5、处理ResultSet
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
            //6、关闭数据库资源
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(resultSet,statement,connection);
        }
    }

    /**
     * 1、向数据表插入一条student记录
     * a、新建一个student，对应examstudent数据表
     * class Student{
     *     int flowId;
     *     int type;
     *     String idCard;
     *     String examCard;
     *     String StudentName;
     *     String location;
     *     int grade;
     * }
     * b、新建一个方法，void addStudent(Student s)将参数Student对象插入到数据库
     * addStudent(Student s){
     *     String sql = "insert into examstudent values(“s.get*”)";
     *     //调用JDBCTools类的update(sql)方法执行插入操作
     * c、在测试方法testAddStudent()中
     *      1、获取从控制台输入的student
     *      Student s = getStudentFromConsole()
     *      2、调用addStudent(Student s)方法执行插入操作
     * }
     * 2、PreparedStatement
     * a、为什么要用PreparedStatement？使用Statement需要进行拼写SQL语句，容易出错
     * b、String sql = "insert into examstudent valuse(?,?,?)"
     * c、使用PreparedStatement
     *      ①创建PreparedStatement
     *      PreparedStatement ps = conn.preparedStatement(sql);
     *      ②调动PreparedStatement的setxxx(int index,object val)设置占位符的值
     *      ③执行SQL语句executeQuery()或executeUpdate()，注意：执行时不再需要传入sql语句
     */
    public void addStudent1(Student s) {
        //准备一个sql语句
        //insert into examstudent values( 20,5,'1122343','2233444','zhangsan','nantong',20)
        String sql = "insert into examstudent values("
                + s.getFlowId() + ","
                + s.getType() + ",'"
                + s.getIdCard() + "','"
                + s.getExamCard() + "','"
                + s.getStudentName() + "','"
                + s.getLocation() + "',"
                + s.getGrade() +")";
        //拼接的SQL打印看下是否正确，不过以后使用PreparedStatement不拼接
        // System.out.println(sql);
        //调用JDBCTools类的update(sql)方法执行插入操作
        //statement不带参数，需要拼接SQL，比较麻烦
        JDBCTools.update(sql);
    }

    public void addStudent2(Student student) {
        //preparedstatement带可变参数，不需要拼接SQL
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
     * 从控制台输入学生的信息
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
        //1、得到查询的类型
        int searchType = getSearchTypeFromConsole();
        //2、具体查询学生信息
        Student student = searchStudent(searchType);
        //3、打印学生信息
        printStudent(student);
    }

    /**
     * 打印学生信息：若学生存在，则打印其具体信息。若不存在，打印查无此人
     * @param student
     */
    private void printStudent(Student student) {
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("查无此人");
        }
    }

    /**
     * 具体查询学生信息。返回一个student对象，若不存在，则返回null
     * @param searchType：1 or 2
     * @return
     */
    private Student searchStudent(int searchType) {
        String sql = "select flowid,type,idcard,examcard,studentname,location,grade" +
                " from examstudent where ";
        Scanner scanner = new Scanner(System.in);
        //1、根据输入的searchType提示用户输入信息
        //若searchType为1，提示：请输入身份证号。为2，提示：请输入准考证号
        //2、根据searchType确定SQL
        if (searchType == 2) {
            System.out.println("请输入准考证号：");
            String examCard = scanner.next();
            sql = sql + " examcard = '" + examCard + "'";
        } else {
            System.out.println("请输入身份证号：");
            String idCard = scanner.next();
            sql = sql + " idcard = '" + idCard + "'";
        } 
        //3、执行查询
        Student student = getStudent(sql);
        //4、若存在查询结果，把结果封装为一个student对象
        return  student;
    }

    /**
     * 根据传入的sql返回student对象
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
     * 从控制台读入一个证书，确定要查询的类型
     * @return 1、用身份证查询 2、用准考证查询。其他无效，并提示用户重新输入
     */
    private int getSearchTypeFromConsole() {
        System.out.println("请输入查询类型：1.用身份证查询，2.用准考证查询");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        if (type != 1 && type != 2) {
            System.out.println("输入错误，请重新输入");
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
     * sql注入
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
                System.out.println("登录成功");
            } else {
                System.out.println("用户名和密码不匹配或者用户名不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(resultSet,statement,connection);
        }
    }

    /**
     * 使用PreparedStatement将有效的解决SQL注入的问题
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
                System.out.println("登录成功");
            } else {
                System.out.println("用户名和密码不匹配或者用户名不存在");
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
            //1、得到ResultSet对象
            resultSet = preparedStatement.executeQuery();
            //2、得到ResultSetMetaData对象
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            //3、创建一个Map<String,Object>对象，键：SQL查询的列的别名，值：列的值
            Map<String, Object> values = new HashMap<>();
            //4、处理结果集，利用ResultSetMetaData填充3对应的Map对象
            if (resultSet.next()) {
                for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                    String columnLabel = resultSetMetaData.getColumnLabel(i + 1);
                    Object columnValue = resultSet.getObject(i + 1);
                    values.put(columnLabel, columnValue);
                }
            }
            //5、若Map不为空，利用反射创建tClass对应的对象
            if (values.size() > 0) {
                entity = tClass.newInstance();
                //遍历Map对象，利用反射为Class对象对应的属性赋值
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
     * 1、是描述ResultSet的元数据对象，即从中可以获取到结果集中有多少列，列名是什么
     * 2、如何使用
     *      a、得到ResultSetMetaData对象，调用ResultSet的getMetaData方法
     *      b、ResultSetMetaData有哪些好用的方法
     *          int getColumnCount：SQL语句包含哪些列
     *          String getColumnLable(int column)：获取指定列的别名，其中索引从1开始
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
            //1、得到ResultSetMetaData对象
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            Map<String, Object> values = new HashMap<>();
            while (resultSet.next()) {
                //2、打印每一列的列名
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
