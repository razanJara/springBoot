package management.device.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import management.device.entity.Manufacturer;
import management.device.entity.Status;
import management.device.enums.Category;
import management.device.enums.Os;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeviceResponse {
    int id;
    String uuid;
    Status status;
    Manufacturer manufacturer;
    Os os;
    Category category;
    LocalDateTime manufactureDate;

}
