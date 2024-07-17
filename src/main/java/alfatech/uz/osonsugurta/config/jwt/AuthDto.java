package alfatech.uz.osonsugurta.config.jwt;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthDto {
    private String email;
    private String password;
}
