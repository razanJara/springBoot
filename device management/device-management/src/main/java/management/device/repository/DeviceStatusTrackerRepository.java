package management.device.repository;

import management.device.entity.Device;
import management.device.entity.DeviceStatusTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceStatusTrackerRepository extends JpaRepository<DeviceStatusTracker, Integer> {

    DeviceStatusTracker findByDeviceId(int deviceId);
}
