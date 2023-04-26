package pub.codex.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 资源服务器配置
 *
 */
@Configuration
@EnableWebSecurity
public class ResourceServerConfig {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/codex/**").permitAll()
                        .requestMatchers("/error").permitAll()
                        .anyRequest().authenticated()
//                        .anyRequest().hasAuthority("SCOPE_console") // 使用hasAuthority过滤token作用范围
                )
                .csrf().disable()
                .oauth2ResourceServer()
                .jwt()
                .decoder(jwtDecoder());
        return http.build();
    }



    @Bean
    public JwtDecoder jwtDecoder() {

        ServiceInstance serviceInstance = loadBalancerClient.choose("codex-server-oauth-center");
        //// TODO: 2023/4/26 待优化
        return NimbusJwtDecoder.withJwkSetUri(serviceInstance.getUri().toString() + "/oauth2/jwks").build();
    }

}