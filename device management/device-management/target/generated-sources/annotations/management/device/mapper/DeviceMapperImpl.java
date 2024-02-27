package management.device.mapper;

import javax.annotation.processing.Generated;
import management.device.dto.request.DeviceRequest;
import management.device.dto.response.DeviceResponse;
import management.device.entity.Device;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-15T09:36:12+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class DeviceMapperImpl implements DeviceMapper {

    @Override
    public DeviceResponse toResponse(Device device) {
        if ( device == null ) {
            return null;
        }

        DeviceResponse deviceResponse = new DeviceResponse();

        deviceResponse.setId( device.getId() );
        deviceResponse.setUuid( device.getUuid() );
        deviceResponse.setStatus( device.getStatus() );
        deviceResponse.setManufacturer( device.getManufacturer() );
        deviceResponse.setOs( device.getOs() );
        deviceResponse.setCategory( device.getCategory() );
        deviceResponse.setManufactureDate( device.getManufactureDate() );

        return deviceResponse;
    }

    @Override
    public Device toEntity(DeviceRequest request) {
        if ( request == null ) {
            return null;
        }

        Device device = new Device();

        device.setOs( request.getOs() );
        device.setCategory( request.getCategory() );

        return device;
    }
}
