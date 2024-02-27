package management.device.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManufacturerRequest {
    int id;
    @Size(max = 50, min = 2, message = "The range for the manufacturer is 2-50 character")
    String name;
}
