package com.mjr.mjrconsumer;

;
import com.mjr.mjrconsumer.model.User;
import com.mjr.mjrconsumer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class MjrConsumerApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(MjrConsumerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.save(new User(1l, "admin", "$2y$08$R4YP6kP60M4o.Cg799NbvOv36xySVFrinlNBPgbWdPNj/dzokMLvq", "proyecto", null));

    }

}
