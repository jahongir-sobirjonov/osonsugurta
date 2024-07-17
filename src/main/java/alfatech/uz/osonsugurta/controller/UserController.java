package alfatech.uz.osonsugurta.controller;

import alfatech.uz.osonsugurta.entity.User;
import alfatech.uz.osonsugurta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public String get(){
        return "Working this";
    }

//    @PostMapping("/register")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//        return ResponseEntity.status(200).body(userService.registerUser(user));
//    }

    @GetMapping("/get-user/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.status(200).body(userService.findByEmail(email).orElse(null));
    }
}
