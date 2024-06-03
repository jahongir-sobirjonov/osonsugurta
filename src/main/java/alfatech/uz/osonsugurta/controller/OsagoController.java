package alfatech.uz.osonsugurta.controller;
import alfatech.uz.osonsugurta.dto.request.OsagoCreateRequest;
import alfatech.uz.osonsugurta.dto.response.HousingResponse;
import alfatech.uz.osonsugurta.dto.response.OsagoResponse;
import alfatech.uz.osonsugurta.service.OsagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("osago")
@RequiredArgsConstructor
public class OsagoController {
    private final OsagoService osagoService;

    @PostMapping("/create")
    public OsagoResponse create(@RequestBody OsagoCreateRequest osagoRequest) {
        return osagoService.create(osagoRequest);
    }

    @GetMapping("get/{id}")
    public OsagoResponse getOsago(@PathVariable UUID id){
        return osagoService.getOsago(id);
    }
}
