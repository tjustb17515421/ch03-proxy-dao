package com.mou;

import com.mou.dao.StudentDao;
import com.mou.domain.Student;
import com.mou.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis {


    //动态代理测试-查询
    @Test
    public void test() {

        //使用mybatis的动态代理，使用SqlSession.getMapper(dao接口的class文件)
        //getMapper能获取dao接口对于实现类的对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        //调用dao的方法，执行数据库的操作
        List<Student> students = dao.selectStudents();
        for (Student stu:students){
            System.out.println("学生="+stu);
        }
    }


    //动态代理测试-插入
    @Test
    public void test1(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setId(1006);
        student.setName("刘对");
        student.setEmail("liubei@qq.com");
        student.setAge(46);
        int nums=dao.insertStudents(student);
        sqlSession.commit();
        System.out.println(nums);
    }
}

