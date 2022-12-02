package bdm.test.shift.controller.dto;

import lombok.Data;

@Data
public class ProductRequestDTO {

    private Long ns;
    private String manufacture;
    private Double price;
    private Integer amount;
    private String type;

    private String formFactor;
    private Integer size;
    private Float diagonal;
    private Integer capacity;

}
