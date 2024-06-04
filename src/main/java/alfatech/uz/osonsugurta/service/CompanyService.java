package alfatech.uz.osonsugurta.service;
import alfatech.uz.osonsugurta.dto.request.CompanyCreateRequest;
import alfatech.uz.osonsugurta.entity.Company;
import alfatech.uz.osonsugurta.exception.DataAlreadyExistsException;
import alfatech.uz.osonsugurta.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;
    public String addServiceToCompany(String companyName, String service) {
        Company company = companyRepository.findByName(companyName)
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));

        company.addService(service);
        companyRepository.save(company);
        return "Successfully added service to " + company.getName();
    }

    public String create(CompanyCreateRequest createRequest) {
        if (companyRepository.existsByName(createRequest.getName())){
            throw new DataAlreadyExistsException("Company already exists with name : " + createRequest.getName());
        }
        Company company = modelMapper.map(createRequest, Company.class);
        companyRepository.save(company);
        return "Successfully created " + createRequest.getName();
    }
}
