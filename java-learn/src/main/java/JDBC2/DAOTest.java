package src.main.java.JDBC2;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DAOTest {
    DAO dao = new DAO();
    @Test
    public void update() {
        String sql = "insert into customers(name,email,birth) values(?,?,?)";
        dao.update(sql,"wang","wang@ntrj.cn","1999-12-12");
    }

    @Test
    public void get() {
        String sql = "select flowid flowId,type,idcard idCard,examcard examCard," +
                "studentname studentName,location,grade from examstudent where flowid = ?";
        Student student = dao.get(Student.class, sql, 4);
        System.out.println(student);
    }

    @Test
    public void getForList() {
        String sql = "select flowid flowId,type,idcard idCard,examcard examCard," +
                "studentname studentName,location,grade from examstudent";
        List<Student> students = dao.getForList(Student.class, sql);
        System.out.println(students);
    }

    @Test
    public void getForValue() {
        String sql = "select examcard examCard from examstudent where flowid = ?";
        String examCard = dao.getForValue(sql, 4);
        System.out.println(examCard);
        sql = "select max(grade) from examstudent";
        int grade = dao.getForValue(sql);
        System.out.println(grade);
    }
}