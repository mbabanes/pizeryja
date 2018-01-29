package pl.kielce.tu.iui.iui.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.kielce.tu.iui.iui.entity.User;
import pl.kielce.tu.iui.iui.repository.UserRepository;
import pl.kielce.tu.iui.iui.security.JwtUserFactory;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(login);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with login '%s'.", login));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
