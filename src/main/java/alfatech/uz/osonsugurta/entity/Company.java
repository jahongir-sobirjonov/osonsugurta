package alfatech.uz.osonsugurta.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import lombok.*;

import java.util.List;

@Entity(name = "companies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Company extends BaseEntity {
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> services;

    public void addService(String service) {
        if (!services.contains(service)) {
            services.add(service);
        }
    }
}
