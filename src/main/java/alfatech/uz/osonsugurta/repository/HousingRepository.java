package alfatech.uz.osonsugurta.repository;

import alfatech.uz.osonsugurta.entity.Housing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface HousingRepository extends JpaRepository<Housing, UUID> {
}
