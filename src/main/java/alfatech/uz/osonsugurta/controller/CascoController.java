package alfatech.uz.osonsugurta.controller;
import alfatech.uz.osonsugurta.dto.request.CascoCreateRequest;
import alfatech.uz.osonsugurta.dto.response.CascoResponse;
import alfatech.uz.osonsugurta.entity.InsurancePolicy;
import alfatech.uz.osonsugurta.service.CascoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("casco")
@RequiredArgsConstructor
public class CascoController {
    private final CascoService cascoService;

    @PostMapping("/create")
    public CascoResponse create(@RequestBody CascoCreateRequest createRequest) {
        return cascoService.create(createRequest);
    }

    @GetMapping("get/{id}")
    public CascoResponse getCasco(@PathVariable UUID id){
        return cascoService.getCasco(id);
    }
}
