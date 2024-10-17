import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.service.UserService;
import com.example.config.AppConfig;

public class MainApp {
    public static void main(String[] args) {
        // Load the Spring context from Java configuration class
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the service bean
        UserService userService = context.getBean(UserService.class);

        // Call methods to trigger AOP
        userService.getUserById(1);
        userService.updateUser(1, "John");
    }
}
