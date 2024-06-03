package alfatech.uz.osonsugurta.service;

import alfatech.uz.osonsugurta.dto.request.CascoCreateRequest;
import alfatech.uz.osonsugurta.dto.response.CascoResponse;
import alfatech.uz.osonsugurta.entity.Casco;
import alfatech.uz.osonsugurta.entity.Company;
import alfatech.uz.osonsugurta.exception.DataNotFoundException;
import alfatech.uz.osonsugurta.repository.CascoRepository;
import alfatech.uz.osonsugurta.repository.CompanyRepository;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CascoService {
    private final CascoRepository cascoRepository;
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public CascoResponse create(CascoCreateRequest cascoRequest) {
        Casco casco = modelMapper.map(cascoRequest, Casco.class);
        List<Company> companies = companyRepository.findByServicesContainingIgnoreCase("Casco");

        for (Company company : companies) {
            System.out.println("company.getName() = " + company.getName());
        }
        casco.setCompany(companies);
        Casco savedCasco = cascoRepository.save(casco);

        List<String> companyListByName = new ArrayList<>();
        for (Company company : companies) {
            companyListByName.add(company.getName());
        }
        CascoResponse cascoResponse = modelMapper.map(savedCasco, CascoResponse.class);
        cascoResponse.setCompaniesName(companyListByName);
        return cascoResponse;
    }

    public CascoResponse getCasco(UUID id) {
        Optional<Casco> byId = cascoRepository.findById(id);

        if (!byId.isPresent()) {
            throw new DataNotFoundException("Casco entity not found for id: " + id);
        }

        Casco casco = byId.get();
        CascoResponse cascoResponse = modelMapper.map(casco, CascoResponse.class);

        List<String> companies = new ArrayList<>();
        for (Company company : casco.getCompany()) {
            companies.add(company.getName());
        }

        cascoResponse.setCompaniesName(companies);
        return cascoResponse;
    }

}
