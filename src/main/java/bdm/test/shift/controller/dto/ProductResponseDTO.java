package bdm.test.shift.controller.dto;

import lombok.Data;

@Data
public class ProductResponseDTO {

    private Long ns;
    private String manufacture;
    private Double price;
    private Integer amount;
    private String type;
}
