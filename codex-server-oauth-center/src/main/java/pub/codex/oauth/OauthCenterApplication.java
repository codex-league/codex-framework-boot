package pub.codex.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
public class OauthCenterApplication {


    public static void main(String[] args) {
        SpringApplication.run(OauthCenterApplication.class, args);
    }
}
