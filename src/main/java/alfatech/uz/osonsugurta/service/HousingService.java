package alfatech.uz.osonsugurta.service;
import alfatech.uz.osonsugurta.dto.request.HousingCreateRequest;
import alfatech.uz.osonsugurta.dto.response.HousingResponse;
import alfatech.uz.osonsugurta.dto.response.OsagoResponse;
import alfatech.uz.osonsugurta.entity.Housing;
import alfatech.uz.osonsugurta.entity.Company;
import alfatech.uz.osonsugurta.entity.Osago;
import alfatech.uz.osonsugurta.exception.DataNotFoundException;
import alfatech.uz.osonsugurta.repository.HousingRepository;
import alfatech.uz.osonsugurta.repository.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HousingService {
    private final HousingRepository housingRepository;
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;
    public HousingResponse create(HousingCreateRequest housingRequest) {
        housingRepository.save(modelMapper.map(housingRequest, Housing.class));
        List<Company> companies = companyRepository.findByServicesContainingIgnoreCase("Housing");
        List<String> companyListByName = new ArrayList<>();
        for (Company company : companies) {
            companyListByName.add(company.getName());
        }
        HousingResponse housingResponse = modelMapper.map(housingRequest, HousingResponse.class);
        housingResponse.setCompaniesName(companyListByName);
        return housingResponse;
    }

    public HousingResponse getHousing(UUID id) {
        Optional<Housing> byId = housingRepository.findById(id);

        if (!byId.isPresent()) {
            throw new DataNotFoundException("Housing entity not found for id: " + id);
        }

        Housing housing = byId.get();
        HousingResponse housingResponse = modelMapper.map(housing, HousingResponse.class);

        List<String> companies = new ArrayList<>();
        for (Company company : housing.getCompanies()) {
            companies.add(company.getName());
        }

        housingResponse.setCompaniesName(companies);
        return housingResponse;
    }




}
