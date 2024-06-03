package alfatech.uz.osonsugurta.controller;
import alfatech.uz.osonsugurta.service.ClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("insurancePolicy")
@RequiredArgsConstructor
public class ClaimController {
    private final ClaimService claimService;
}
