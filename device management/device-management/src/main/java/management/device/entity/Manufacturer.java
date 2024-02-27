package management.device.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Manufacturer {
    @Id
    @GeneratedValue
    int id;
    @Column
    String name;
    @OneToMany
    List<Device> devices;
}
