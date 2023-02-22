import com.L.pojo.Users;
import com.L.service.UsersService;
import com.L.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class UserServiceTest {
    @Test
    public void Run1(){
        ApplicationContext apc=new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService us=apc.getBean(UsersService.class);
        Users user=us.Login("ff","ff");
        System.out.println(user);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Users user2=us.Register1("admin2","admin","","");
        if (user2 != null) System.out.println("Success");
        else System.out.println("Error");
        System.out.println(user2);
    }

    @Test
    public void Run2(){
        Random random=new Random();
        int r=random.nextInt(100000000);
        System.out.println(r);
    }
    @Test
    public void Run3(){
     try {
         System.out.println(Integer.parseInt("sss"));
     }catch (Exception e){
         System.out.println("NO");
     }
        System.out.println(Integer.parseInt("11"));
    }
}
