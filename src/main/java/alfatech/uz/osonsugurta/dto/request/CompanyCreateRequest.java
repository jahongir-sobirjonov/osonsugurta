package alfatech.uz.osonsugurta.dto.request;

import lombok.*;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class CompanyCreateRequest {
    private String name;
    private List<String> services;
}
