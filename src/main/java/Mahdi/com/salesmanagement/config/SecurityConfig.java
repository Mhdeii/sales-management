package Mahdi.com.salesmanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/products/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/clients/**").hasRole("ADMIN")
                .antMatchers("/api/sales/**").authenticated()
                .and()
                .httpBasic();
    }
}