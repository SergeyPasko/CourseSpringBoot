package lesson38;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"lesson38"/* ,"lesson39", "lesson40" */}, exclude = {
        SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})
public class CourseSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(CourseSpringBoot.class, args);
    }
}
