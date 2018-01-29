package com.clinic.clinic_be.security.service;

import com.clinic.clinic_be.persistence.entities.User;
import com.clinic.clinic_be.persistence.repositories.UserRepository;
import com.clinic.clinic_be.security.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findActiveByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with login '%s'.", login));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
