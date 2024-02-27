package management.device.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import management.device.Exception.BusinessException;
import management.device.dto.request.DeviceRequest;
import management.device.dto.response.DeviceResponse;
import management.device.entity.Device;
import management.device.entity.Manufacturer;
import management.device.entity.Status;
import management.device.enums.Category;
import management.device.enums.Os;
import management.device.mapper.DeviceMapper;
import management.device.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DeviceService {
    DeviceRepository deviceRepository;
    DeviceMapper deviceMapper;
    StatusService statusService;
    ManufacturerService manufacturerService;
    DeviceStatusTrackerService deviceStatusTrackerService;
    public DeviceResponse createDevice(DeviceRequest request){
        Status status =  statusService.getStatusById(request.getStatusId());
        Manufacturer manufacturer = manufacturerService.getById(request.getManufacturerId());
        Device entity = deviceMapper.toEntity(request);
        entity.setStatus(status);
        entity.setUuid(UUID.randomUUID().toString());
        entity.setManufacturer(manufacturer);
        entity.setManufactureDate(request.getDate());
        Device device = deviceRepository.save(entity);
        deviceStatusTrackerService.addNewTracker(status.getId(),device);

       return deviceMapper.toResponse(device);
    }


    public List<DeviceResponse> getAll() {
        return deviceRepository
                .findAll()
                .stream()
                .map(deviceMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<DeviceResponse> getByOs(Os os) {
        return deviceRepository
                .findByOs(os)
                .stream()
                .map(deviceMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<DeviceResponse> getByCategory(Category category) {
        return deviceRepository
                .findByCategory(category)
                .stream()
                .map(deviceMapper::toResponse)
                .collect(Collectors.toList());
    }

    public DeviceResponse getByUUID(String uuid) {
       Device device= deviceRepository.findByUuid(uuid);
       return deviceMapper.toResponse(device);
    }

    public DeviceResponse updateStatus(int statusID, int deviceID) {
        Status status =  statusService.getStatusById(statusID);
        status.setId(statusID);
        Device device = deviceRepository.findById(deviceID).orElseThrow(()-> new BusinessException("No Device with such ID!!!!"));
        device.setStatus(status);
        deviceStatusTrackerService.UpdateStatus(statusID, deviceID);
        return deviceMapper.toResponse(device);
    }

    public List<DeviceResponse> getByManufacturerId(int manufacturerId) {
        return deviceRepository.findByManufacturerId(manufacturerId).stream().map(deviceMapper::toResponse).collect(Collectors.toList());
    }


}
