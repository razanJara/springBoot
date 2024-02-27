package management.device.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import management.device.Exception.BusinessException;
import management.device.entity.Status;
import management.device.repository.StatusRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StatusService {
    StatusRepository statusRepository;
    public Status getStatusById(int statusId) {
       return statusRepository.findById(statusId).orElseThrow(()->new BusinessException("No status with such ID"));
    }
}
