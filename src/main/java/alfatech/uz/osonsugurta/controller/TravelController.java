package alfatech.uz.osonsugurta.controller;
import alfatech.uz.osonsugurta.dto.request.TravelCreateRequest;
import alfatech.uz.osonsugurta.dto.response.HousingResponse;
import alfatech.uz.osonsugurta.dto.response.TravelResponse;
import alfatech.uz.osonsugurta.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("travel")
@RequiredArgsConstructor
public class TravelController {
    private final TravelService travelService;

    @PostMapping("/create")
    public TravelResponse create(@RequestBody TravelCreateRequest travelRequest) {
        return travelService.create(travelRequest);
    }

    @GetMapping("get/{id}")
    public TravelResponse getTravel(@PathVariable UUID id){
        return travelService.getTravel(id);
    }
}
