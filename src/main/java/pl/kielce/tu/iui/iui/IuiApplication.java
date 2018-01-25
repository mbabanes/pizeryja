package pl.kielce.tu.iui.iui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import pl.kielce.tu.iui.iui.config.CustomUserDetails;
import pl.kielce.tu.iui.iui.entity.User;
import pl.kielce.tu.iui.iui.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class IuiApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(IuiApplication.class, args);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception
    {
        builder.userDetailsService(email -> new CustomUserDetails(repo.findByEmail(email)));
    }
}

