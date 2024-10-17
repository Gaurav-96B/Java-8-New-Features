import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.service.UserService;

public class MainApp {
    public static void main(String[] args) {
        // Load the Spring context from XML
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Retrieve the service bean
        UserService userService = (UserService) context.getBean("userService");

        // Call methods to trigger AOP
        userService.getUserById(1);
        userService.updateUser(1, "John");
    }
}
