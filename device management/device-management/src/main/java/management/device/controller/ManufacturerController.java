package management.device.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import management.device.entity.Manufacturer;
import management.device.service.ManufacturerService;
import org.springframework.web.bind.annotation.*;
import management.device.dto.request.ManufacturerRequest;
import management.device.dto.response.ManufacturerResponse;

import java.util.List;

@RestController
@RequestMapping("manufacturer")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ManufacturerController {
    ManufacturerService manufacturerService;
    @PostMapping
    public ManufacturerResponse createMan(@Valid @RequestBody ManufacturerRequest request)
    {
        return manufacturerService.createManufacturer(request);
    }
    @PutMapping ("/{id}")
    public ManufacturerResponse update(@RequestBody ManufacturerRequest request, @PathVariable int id)
    {
        return manufacturerService.updateMan(request, id);
    }
    @GetMapping
    public List<ManufacturerResponse> showAll()
    {
        return manufacturerService.showAll();
    }
    @GetMapping("/manufacturers/{id}")
    public Manufacturer showById(@PathVariable int id)
    {
        return manufacturerService.showById(id);
    }
}
