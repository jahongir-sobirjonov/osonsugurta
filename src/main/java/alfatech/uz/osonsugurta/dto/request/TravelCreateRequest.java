package alfatech.uz.osonsugurta.dto.request;

import jakarta.annotation.Nullable;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class TravelCreateRequest {
    private String country;
    private String policyType;
    private LocalDate startDate;
    private LocalDate endDate;
    private int days;
    private String tripPurpose;

}
