package pub.codex.usercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pub.codex.index.EnableCodexLeague;

@ComponentScan("pub.codex.**")
@SpringBootApplication
@EnableCodexLeague // 添加codex启用信息
public class UserCenterApplication {


    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }
}
