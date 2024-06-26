package alfatech.uz.osonsugurta.dto.response;
import jakarta.annotation.Nullable;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class OsagoResponse {
    private String carRegNumber;
    private String texPassportSeries;
    private String texPassportNumber;
    private List<String> companiesName;
}
