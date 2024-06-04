package alfatech.uz.osonsugurta.controller;
import alfatech.uz.osonsugurta.dto.request.CompanyCreateRequest;
import alfatech.uz.osonsugurta.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/create")
    public String create(@RequestBody CompanyCreateRequest createRequest){
        return companyService.create(createRequest);
    }


    @PostMapping("/add-service/{companyName}")
    public String addService(@PathVariable String companyName, @RequestParam String serviceName){
        return companyService.addServiceToCompany(companyName, serviceName);
    }

    @GetMapping("/services")
    public List<String> getCompaniesByService(@RequestParam String service) {
        return companyService.getCompaniesByService(service);
    }
}
