package com.clinic.clinic_be.security.controllers;

import com.clinic.clinic_be.persistence.entities.Doctor;
import com.clinic.clinic_be.persistence.entities.Patient;
import com.clinic.clinic_be.persistence.entities.User;
import com.clinic.clinic_be.persistence.repositories.UserRepository;
import com.clinic.clinic_be.security.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoggedUserComponent {

    @Autowired
    private UserRepository userRepository;

    private JwtUser loggedUser;

    private JwtUser getLoggedUser() {
        try {
            if (loggedUser == null) {
                loggedUser = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            }
            return loggedUser;
        } catch (Exception ex) {
            return null;
        }
    }

    public Long getLoggedUserId() {
        try {
            return getLoggedUser().getId();
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public Patient getLoggedPatient() {
        try {
            User user = userRepository.findOne(getLoggedUserId());
            return user.getPatient();
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public Doctor getLoggedDoctor() {
        try {
            User user = userRepository.findOne(getLoggedUserId());
            return user.getDoctor();
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public void setLoggedUser(JwtUser user) {
        this.loggedUser = user;
    }
}
