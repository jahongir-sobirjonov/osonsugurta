package alfatech.uz.osonsugurta.service;

import alfatech.uz.osonsugurta.entity.Payment;
import alfatech.uz.osonsugurta.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public Payment makePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
