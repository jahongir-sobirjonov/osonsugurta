package alfatech.uz.osonsugurta.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class CascoResponse {
    private String carRegNumber;
    private String texPassportSeries;
    private String texPassportNumber;
    private String carBrand;
    private String carModel;
    private Integer carReleaseYear;
    private List<String> companiesName;
}
