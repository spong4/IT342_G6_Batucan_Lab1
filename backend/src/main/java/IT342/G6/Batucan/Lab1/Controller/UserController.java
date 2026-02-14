package IT342.G6.Batucan.Lab1.Controller;

import IT342.G6.Batucan.Lab1.Config.TokenProvider;
import IT342.G6.Batucan.Lab1.Entity.User;
import IT342.G6.Batucan.Lab1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7);
            if (tokenProvider.validateToken(jwt)) {
                String email = tokenProvider.getEmailFromToken(jwt);
                return ResponseEntity.ok(userRepository.findByEmail(email).orElse(null));
            }
        }
        return ResponseEntity.status(401).body("Unauthorized access");
    }
}