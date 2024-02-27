package management.device.mapper;

import management.device.dto.request.DeviceRequest;
import management.device.dto.response.DeviceResponse;
import management.device.entity.Device;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceMapper {
    DeviceResponse toResponse(Device device);
    Device toEntity(DeviceRequest request);
}
