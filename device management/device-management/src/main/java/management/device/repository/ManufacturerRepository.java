package management.device.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import management.device.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
    Manufacturer findById(long manufacturerId);
}
