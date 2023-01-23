package pl.bestapp.timesheetmanager.controller;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.bestapp.timesheetmanager.dto.request.LoginRequest;
import pl.bestapp.timesheetmanager.dto.request.UserRequest;
import pl.bestapp.timesheetmanager.service.UserService;

@AllArgsConstructor
@RestController("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        logger.info("/registration request: {}", loginRequest);

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User logged in successfully.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserRequest userRequest) {
        logger.info("/registration request: {}", userRequest);

        if (userService.checkIfUserExists(userRequest.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        userService.save(userRequest);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}
