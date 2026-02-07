package IT342.G6.Batucan.Lab1.Controller;

import IT342.G6.Batucan.Lab1.Entity.User;
import IT342.G6.Batucan.Lab1.Dto.LoginRequest;
import IT342.G6.Batucan.Lab1.Service.AuthService;
import IT342.G6.Batucan.Lab1.Config.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return ResponseEntity.ok(authService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<User> user = authService.authenticate(request.getEmail(), request.getPassword());
        if (user.isPresent()) {
            String token = tokenProvider.generateToken(user.get());
            return ResponseEntity.ok(java.util.Map.of("token", token, "user", user.get()));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}