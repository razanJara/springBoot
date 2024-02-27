package management.device.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class DeviceRequest {
    @NotNull
    @Enumerated(EnumType.STRING)
    Os os;
    @NotNull
    @Enumerated(EnumType.STRING)
    Category category;
    @NotNull
    @Positive(message = "The manufacturer ID must not be Zero nor Negative")
    long manufacturerId;
    @NotNull
    @Positive(message = "The status ID must not be Zero nor Negative")
    int statusId;
    @NotNull
    LocalDateTime date;


}
