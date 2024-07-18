package alfatech.uz.osonsugurta.controller;

import alfatech.uz.osonsugurta.config.jwt.AuthDto;
import alfatech.uz.osonsugurta.config.jwt.JwtResponse;
import alfatech.uz.osonsugurta.dto.request.UserCreateRequest;
import alfatech.uz.osonsugurta.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/sign-in")
    public JwtResponse signIn(@Valid @RequestBody AuthDto dto) {
        return userService.signIn(dto);
    }

    @PostMapping("/sign-up")
    public String auth(@Valid @RequestBody UserCreateRequest dto) {
        return userService.signUp(dto);
    }
}
