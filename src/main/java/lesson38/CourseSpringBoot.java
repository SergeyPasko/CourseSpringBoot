package lesson38;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"lesson38","lesson39"})
public class CourseSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(CourseSpringBoot.class, args);
    }
}
