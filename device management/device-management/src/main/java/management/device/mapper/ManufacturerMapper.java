package management.device.mapper;

import management.device.dto.request.ManufacturerRequest;
import management.device.dto.response.ManufacturerResponse;
import management.device.entity.Manufacturer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ManufacturerMapper {
    Manufacturer toManufacturer(ManufacturerRequest request);
    ManufacturerResponse toResponse(Manufacturer manufacturer);
}
