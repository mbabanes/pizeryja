package pl.kielce.tu.iui.iui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@SuppressWarnings("SpringJavaAutowiringInspection")
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig /*extends WebSecurityConfigurerAdapter */{

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                // don't create session
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .authorizeRequests()
////      CONTROLLERS
//                .antMatchers(HttpMethod.GET, "/hello/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/user/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/components/**").permitAll()
//
////      SWAGGER
//                .antMatchers("/v2/api-docs").permitAll()
//                .antMatchers("/swagger**").permitAll()
//                .antMatchers("/swagger**/**").permitAll()
//                .antMatchers("/webjars/**").permitAll()
////      OTHERS
//                .antMatchers("/**").permitAll()
//                .and()
//                .csrf().disable();
//
//        // disable page caching
//        http.headers().cacheControl();
//    }


}

