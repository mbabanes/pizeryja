package com.clinic.clinic_be.security;

import com.clinic.clinic_be.common.enums.EntityVisibilityEnum;
import com.clinic.clinic_be.persistence.entities.AppRolePrivilege;
import com.clinic.clinic_be.persistence.entities.Privilege;
import com.clinic.clinic_be.persistence.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getLogin(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getAppRole().getAppRolePrivileges()),
                isUserActive(user.getVisibility()),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<AppRolePrivilege> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getPrivilege().getName()))
                .collect(Collectors.toList());
    }

    private static boolean isUserActive(EntityVisibilityEnum visibility) {
        return visibility.equals(EntityVisibilityEnum.ACTIVE);
    }
}
