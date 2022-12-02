package bdm.test.shift.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hdds")
@Data
public class HardDiskDrive extends Product {

    private Integer capacity;
}
