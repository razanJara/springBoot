package management.device.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import management.device.dto.request.DeviceRequest;
import management.device.dto.response.DeviceResponse;
import management.device.enums.Category;
import management.device.enums.Os;
import management.device.service.DeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DeviceController {
    DeviceService deviceService;
    @PostMapping
    public DeviceResponse create(@Valid @RequestBody DeviceRequest request){
        return deviceService.createDevice(request);
    }
    @GetMapping
    public List<DeviceResponse> getAll() {
        return deviceService.getAll();
    }
    @GetMapping("/{os}")
    public List<DeviceResponse> getByOs(@PathVariable Os os) {
        return deviceService.getByOs(os);
    }
    @GetMapping("/category/{category}")
    public List<DeviceResponse> getByCategory(@PathVariable Category category) {
        return deviceService.getByCategory(category);
    }
    @GetMapping("/uuid/{uuid}")
    public DeviceResponse getByUUID(@PathVariable String uuid)
    {
        return deviceService.getByUUID(uuid);
    }
    @PutMapping("/{deviceID}/{statusID}")
    public DeviceResponse updateStatus(@PathVariable int statusID,@PathVariable int deviceID) {
        return deviceService.updateStatus(statusID, deviceID);
    }
    @GetMapping("/manufacturer/{manufacturerId}")
    public List<DeviceResponse> showByManufacturer(@PathVariable int manufacturerId)
    {
        return deviceService.getByManufacturerId(manufacturerId);
    }

}
