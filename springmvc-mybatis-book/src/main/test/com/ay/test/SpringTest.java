import com.ay.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
/**
 * @author Ay
 * @date 2018/04/02
 */
@Service
public class SpringTest {

    @Test
    public void testSpring(){
        //获取运用上下文
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取SpringTest类
        User springTest = (User) applicationContext.getBean("user",User.class);
        //调用sayHello方法
        springTest.Add();
    }

}
