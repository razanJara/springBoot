package management.device.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import management.device.dto.request.ManufacturerRequest;
import management.device.dto.response.ManufacturerResponse;
import management.device.entity.Manufacturer;
import management.device.mapper.ManufacturerMapper;
import management.device.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ManufacturerService {
    ManufacturerRepository manufacturerRepository;
    ManufacturerMapper manufacturerMapper;

    public Manufacturer getById(long manufacturerId) {
        return manufacturerRepository.findById(manufacturerId);
    }

    public ManufacturerResponse createManufacturer(ManufacturerRequest request) {
        Manufacturer manufacturer = manufacturerRepository.save(manufacturerMapper.toManufacturer(request));
        return manufacturerMapper.toResponse(manufacturer);
    }

    public ManufacturerResponse updateMan(ManufacturerRequest request, int id) {
        Manufacturer manufacturer = manufacturerRepository.findById(id);
        manufacturer.setName(request.getName());
        manufacturerRepository.save(manufacturer);
        return manufacturerMapper.toResponse(manufacturer);
    }

    public List<ManufacturerResponse> showAll() {
        return manufacturerRepository.findAll().stream().map(manufacturerMapper::toResponse).collect(Collectors.toList());
    }

    public Manufacturer showById(int id) {
        return manufacturerRepository.findById(id);
    }
}
