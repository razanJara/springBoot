package management.device.repository;

import management.device.entity.Device;
import management.device.enums.Category;
import management.device.enums.Os;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
    List<Device> findByOs(Os os);

    List<Device> findByCategory(Category category);

    Device findByUuid(String uuid);

    List<Device> findByManufacturerId(int manufacturerId);
}
