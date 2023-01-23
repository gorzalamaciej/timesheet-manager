package pl.bestapp.timesheetmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.bestapp.timesheetmanager.dto.request.UserRequest;
import pl.bestapp.timesheetmanager.dto.response.UserResponse;
import pl.bestapp.timesheetmanager.model.User;

import java.util.Set;

@AllArgsConstructor
@Service
public class UserService {

    private static final String ADMIN_ROLE = "ADMIN";

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserResponse findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(m -> UserResponse.builder()
                        .id(m.getId())
                        .name(m.getName())
                        .lastName(m.getSurname())
                        .email(m.getEmail())
                        .active(m.isActive())
                        .build()).orElse(null);
    }

    public void save(UserRequest request) {
        userRepository.save(User.builder()
                .surname(request.getSurname())
                .email(request.getEmail())
                .active(true)
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .roles(Set.of(roleRepository.findByRole(ADMIN_ROLE)))
                .build());
    }

    public boolean checkIfUserExists(String userEmail) {
        return userRepository.findByEmail(userEmail).isPresent();
    }

}
