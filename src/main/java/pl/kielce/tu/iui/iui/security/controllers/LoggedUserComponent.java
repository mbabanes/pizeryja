package pl.kielce.tu.iui.iui.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import pl.kielce.tu.iui.iui.repository.UserRepository;
import pl.kielce.tu.iui.iui.security.JwtUser;

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

    public void setLoggedUser(JwtUser user) {
        this.loggedUser = user;
    }
}
