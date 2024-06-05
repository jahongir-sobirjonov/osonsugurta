package alfatech.uz.osonsugurta.controller;

import alfatech.uz.osonsugurta.entity.Payment;
import alfatech.uz.osonsugurta.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/make")
    public ResponseEntity<Payment> makePayment(@RequestBody Payment payment) {
        return ResponseEntity.status(200).body(paymentService.makePayment(payment));
    }
}
