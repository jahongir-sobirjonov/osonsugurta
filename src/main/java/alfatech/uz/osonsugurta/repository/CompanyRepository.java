package alfatech.uz.osonsugurta.repository;

import alfatech.uz.osonsugurta.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {
    List<Company> findByServicesContainingIgnoreCase(String service);

    Optional<Company> findByName(String companyName);

    boolean existsByName(String name);

    List<Company> findByServicesIgnoreCaseContaining(String service);
}
