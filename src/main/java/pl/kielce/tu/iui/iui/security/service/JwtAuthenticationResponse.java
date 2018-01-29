package com.clinic.clinic_be.security.service;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;
    private final String page;

    public JwtAuthenticationResponse(String token, String page) {
        this.token = token;
        this.page = page;
    }

    public String getToken() {
        return this.token;
    }

    public String getPage() {
        return page;
    }
}
