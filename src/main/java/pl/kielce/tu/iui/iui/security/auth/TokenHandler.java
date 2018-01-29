package pl.kielce.tu.iui.iui.security.auth;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import pl.kielce.tu.iui.iui.security.enums.TokenStatusEnum;

@Service
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TokenHandler {

    private String token;
    private TokenStatusEnum status;

    public String getToken() {
        if (this.token != null) {
            return this.token;
        } else {
            return null;
        }
    }

    public void setToken(String token) {
        this.token = token;
        this.status = TokenStatusEnum.ACTIVE;
    }

    public boolean isTokenActive() {
        return this.status != null && this.status.equals(TokenStatusEnum.ACTIVE);
    }

    public void invalidateToken() {
        if (this.token != null) {
            this.status = TokenStatusEnum.INVALIDATED;
            this.token = null;
        }
    }
}
