package IT342.G6.Batucan.Lab1.Repository;

import IT342.G6.Batucan.Lab1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}