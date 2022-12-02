package bdm.test.shift.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "monitors")
@Data
public class Monitor extends Product{

    private Float diagonal;
}
