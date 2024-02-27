package management.device.mapper;

import javax.annotation.processing.Generated;
import management.device.dto.request.ManufacturerRequest;
import management.device.dto.response.ManufacturerResponse;
import management.device.entity.Manufacturer;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-15T09:36:12+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class ManufacturerMapperImpl implements ManufacturerMapper {

    @Override
    public Manufacturer toManufacturer(ManufacturerRequest request) {
        if ( request == null ) {
            return null;
        }

        Manufacturer manufacturer = new Manufacturer();

        manufacturer.setId( request.getId() );
        manufacturer.setName( request.getName() );

        return manufacturer;
    }

    @Override
    public ManufacturerResponse toResponse(Manufacturer manufacturer) {
        if ( manufacturer == null ) {
            return null;
        }

        ManufacturerResponse manufacturerResponse = new ManufacturerResponse();

        manufacturerResponse.setId( manufacturer.getId() );
        manufacturerResponse.setName( manufacturer.getName() );

        return manufacturerResponse;
    }
}
