package alfatech.uz.osonsugurta.service;

import alfatech.uz.osonsugurta.config.jwt.AuthDto;
import alfatech.uz.osonsugurta.config.jwt.JwtResponse;
import alfatech.uz.osonsugurta.config.jwt.JwtService;
import alfatech.uz.osonsugurta.dto.request.UserCreateRequest;
import alfatech.uz.osonsugurta.entity.User;
import alfatech.uz.osonsugurta.entity.enums.UserRole;
import alfatech.uz.osonsugurta.exception.DataNotFoundException;
import alfatech.uz.osonsugurta.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public String signUp(UserCreateRequest dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("this email is already exists: " + dto.getEmail());
        }
        User user = modelMapper.map(dto, User.class);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(UserRole.USER);
        userRepository.save(user);
        return "Successfully registered";

    }

    public JwtResponse signIn(AuthDto dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new DataNotFoundException("User not found"));

        if (passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            String accessToken = jwtService.generateToken(user);
            return new JwtResponse(accessToken);
        } else {
            throw new AuthenticationCredentialsNotFoundException("Invalid credentials");
        }
    }
}
