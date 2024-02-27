package management.device.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeviceStatusTracker {
    @Id
    @GeneratedValue
    int id;
    @OneToOne
    Device device;
    @Column
    int newStatus;
    @Column
    int oldStatus;
    @Column
    LocalDateTime date;

}
