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
public class HousingCreateRequest {
    private String passportSeries;
    private String passportNumber;
    private LocalDate dateOfBirth;
    private String familyName;
    private String givenName;
    private String fathersName;
    private String phoneNumber;
    private String residentialRegion;
    private String civilRegistryNumber;

}
