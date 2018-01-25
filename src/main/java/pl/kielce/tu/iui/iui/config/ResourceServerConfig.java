package pl.kielce.tu.iui.iui.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter
{
    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/", "/home", "/component/**").permitAll()
                .antMatchers("/private/**").authenticated()
                .antMatchers("/order/**").authenticated()
                .antMatchers("/component/add", "/pizza/create").hasAuthority("ROLE_ADMIN")
                        .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/swagger**").permitAll()
                .antMatchers("/swagger**/**").permitAll()
                .antMatchers("/webjars/**").permitAll();
    }


}
