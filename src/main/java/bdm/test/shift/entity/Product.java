package bdm.test.shift.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "products")
public class Product {

    @Id
    private Long ns;
    private String manufacture;
    private Double price;
    private Integer amount;
    private String type;
}
