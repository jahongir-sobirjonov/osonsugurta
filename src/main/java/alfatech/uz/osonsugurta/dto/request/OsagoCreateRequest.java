package alfatech.uz.osonsugurta.dto.request;
import jakarta.annotation.Nullable;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class OsagoCreateRequest {
    private String carRegNumber;
    private String texPassportSeries;
    private String texPassportNumber;

}
