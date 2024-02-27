package management.device.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import management.device.enums.Category;
import management.device.enums.Os;

import java.time.LocalDateTime;

@Entity
@Table (name = "device")
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Device {
    @Id
    @GeneratedValue
    int id;
    @Enumerated(EnumType.STRING)
    Os os;
    @Enumerated(EnumType.STRING)
    Category category;
    @Column
    String uuid;
    @Column
    LocalDateTime manufactureDate;
    @ManyToOne
    @JoinColumn(name="status_id")
    Status status;
    @ManyToOne
    @JoinColumn(name="manufacturer_id")
    Manufacturer manufacturer;



}
