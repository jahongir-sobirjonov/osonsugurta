package alfatech.uz.osonsugurta.repository;

import alfatech.uz.osonsugurta.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    Optional<User> findUserByEmail(String email);

    boolean existsByEmail(String email);
}
