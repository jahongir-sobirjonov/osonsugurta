package alfatech.uz.osonsugurta.controller;
import alfatech.uz.osonsugurta.dto.request.HousingCreateRequest;
import alfatech.uz.osonsugurta.dto.response.HousingResponse;
import alfatech.uz.osonsugurta.dto.response.HousingResponse;
import alfatech.uz.osonsugurta.service.HousingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("housing")
@RequiredArgsConstructor
public class HousingController {
    private final HousingService housingService;

    @PostMapping("/create")
    public HousingResponse create(@RequestBody HousingCreateRequest housingRequest) {
        return housingService.create(housingRequest);
    }

    @GetMapping("get/{id}")
    public HousingResponse getHousing(@PathVariable UUID id){
        return housingService.getHousing(id);
    }
}
