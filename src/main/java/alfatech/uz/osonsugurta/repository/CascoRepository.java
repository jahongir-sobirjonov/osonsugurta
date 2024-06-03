package alfatech.uz.osonsugurta.repository;

import alfatech.uz.osonsugurta.entity.Casco;
import alfatech.uz.osonsugurta.entity.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CascoRepository extends JpaRepository<Casco, UUID> {
}
