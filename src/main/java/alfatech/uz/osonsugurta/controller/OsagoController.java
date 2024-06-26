package alfatech.uz.osonsugurta.controller;

import alfatech.uz.osonsugurta.dto.request.OsagoCreateRequest;
import alfatech.uz.osonsugurta.dto.response.OsagoResponse;
import alfatech.uz.osonsugurta.service.OsagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("osago")
@RequiredArgsConstructor
public class OsagoController {
    private final OsagoService osagoService;

    @PostMapping("/create")
    public ResponseEntity<OsagoResponse> create(@RequestBody OsagoCreateRequest osagoRequest) {
        return ResponseEntity.status(200).body(osagoService.create(osagoRequest));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<OsagoResponse> getOsago(@PathVariable UUID id){
        return ResponseEntity.status(200).body(osagoService.getOsago(id));
    }
}
