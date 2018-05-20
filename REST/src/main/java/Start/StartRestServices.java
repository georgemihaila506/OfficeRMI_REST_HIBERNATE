package Start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("office")
@SpringBootApplication
public class StartRestServices {
    public static void main(String[] args) {

        SpringApplication.run(StartRestServices.class, args);
    }
}
