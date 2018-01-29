package pl.kielce.tu.iui.iui.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.iui.iui.repository.UserRepository;
import pl.kielce.tu.iui.iui.security.JwtAuthenticationRequest;
import pl.kielce.tu.iui.iui.security.JwtTokenUtil;
import pl.kielce.tu.iui.iui.security.JwtUser;
import pl.kielce.tu.iui.iui.security.auth.TokenHandler;
import pl.kielce.tu.iui.iui.security.exceptions.UnauthorizedException;
import pl.kielce.tu.iui.iui.security.service.JwtAuthenticationResponse;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenHandler tokenHandler;
    @Autowired
    private LoggedUserComponent loggedUserComponent;

    @CrossOrigin
    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<JwtAuthenticationResponse> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails, device);
        tokenHandler.setToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        loggedUserComponent.setLoggedUser(user);
        return new ResponseEntity(new JwtAuthenticationResponse(token), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<String> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return new ResponseEntity<>(refreshedToken, HttpStatus.OK);

        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "${jwt.route.authentication.logout}", method = RequestMethod.POST)
    public ResponseEntity invalidateToken() {
        tokenHandler.invalidateToken();
        loggedUserComponent.setLoggedUser(null);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void authorizeQueueRequest(String token) throws UnauthorizedException {
        try {
            String username = jwtTokenUtil.getUsernameFromToken(token);
            JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
            if (user == null) {
                throw new UnauthorizedException();
            }
        } catch (Exception ex) {
            throw new UnauthorizedException();
        }
    }
}
