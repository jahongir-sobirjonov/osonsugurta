package alfatech.uz.osonsugurta.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserCreateRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
