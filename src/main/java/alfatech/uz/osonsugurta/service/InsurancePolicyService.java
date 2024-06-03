package alfatech.uz.osonsugurta.service;

import alfatech.uz.osonsugurta.entity.InsurancePolicy;
import alfatech.uz.osonsugurta.entity.User;
import alfatech.uz.osonsugurta.repository.InsurancePolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsurancePolicyService {
    private final InsurancePolicyRepository insurancePolicyRepository;
    public InsurancePolicy createPolicy(InsurancePolicy policy) {
        return insurancePolicyRepository.save(policy);
    }

    public List<InsurancePolicy> findPoliciesByUser(User user) {
        return insurancePolicyRepository.findByUser(user);
    }
}
