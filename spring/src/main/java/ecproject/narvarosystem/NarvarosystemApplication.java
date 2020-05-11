package ecproject.narvarosystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class NarvarosystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(NarvarosystemApplication.class, args);
    }

}
