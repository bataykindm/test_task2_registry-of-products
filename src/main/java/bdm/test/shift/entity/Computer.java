package bdm.test.shift.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "computers")
@Data
public class Computer extends Product {

    private String formFactor;
}
