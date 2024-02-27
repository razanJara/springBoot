package management.device.service;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import management.device.entity.Device;
import management.device.entity.DeviceStatusTracker;
import management.device.entity.Status;
import management.device.repository.DeviceStatusTrackerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DeviceStatusTrackerService {
    DeviceStatusTrackerRepository deviceStatusTrackerRepository;

    public void addNewTracker(int statusId, Device device) {
        DeviceStatusTracker tracker = new DeviceStatusTracker();
        tracker.setNewStatus(statusId);
        tracker.setDevice(device);
        tracker.setDate(LocalDateTime.now());
        deviceStatusTrackerRepository.save(tracker);
    }

    public void UpdateStatus(int statusID, int deviceId) {
       DeviceStatusTracker tracker = deviceStatusTrackerRepository.findByDeviceId(deviceId);
       tracker.setOldStatus(tracker.getNewStatus());
       tracker.setNewStatus(statusID);
       deviceStatusTrackerRepository.save(tracker);
    }
}
