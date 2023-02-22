import com.L.mapper.UserMapper;
import com.L.pojo.Users;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void Run1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        SqlSession sqlSession= (SqlSession) applicationContext.getBean("sqlSession");
        UserMapper um=sqlSession.getMapper(UserMapper.class);
        um.insertUser(new Users(0,"admin","admin","admin","admin"));
        um.deleteUserById(7);
        List<Users> users=um.selectUser("admin","admin");
        for (Users users1:users){
            System.out.println(users1);
        }
        //Manual commit is not allowed over a Spring managed SqlSession
        //sqlSession.commit();
        //Manual close is not allowed over a Spring managed SqlSession
        //sqlSession.close();
    }
}
