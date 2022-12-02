package bdm.test.shift.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "laptops")
@Data
public class Laptop extends Product {

    private Integer size;
}
