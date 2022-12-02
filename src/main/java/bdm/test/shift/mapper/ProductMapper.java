package bdm.test.shift.mapper;

import bdm.test.shift.controller.dto.ProductRequestDTO;
import bdm.test.shift.entity.*;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product mapToProduct(ProductRequestDTO productRequestDTO, Product product) {

        product.setNs(productRequestDTO.getNs());
        product.setManufacture(productRequestDTO.getManufacture());
        product.setPrice(productRequestDTO.getPrice());
        product.setAmount(productRequestDTO.getAmount());
        product.setType(productRequestDTO.getType());

        return setPropertyToProductAccordingType(productRequestDTO, product);
    }

    private Product setPropertyToProductAccordingType(ProductRequestDTO productRequestDTO, Product product) {
        if (product.getClass() == Computer.class) {
            ((Computer) product).setFormFactor(productRequestDTO.getFormFactor());
        }
        if (product.getClass() == Laptop.class) {
            ((Laptop) product).setSize(productRequestDTO.getSize());
        }
        if (product.getClass() == Monitor.class) {
            ((Monitor) product).setDiagonal(productRequestDTO.getDiagonal());
        }
        if (product.getClass() == HardDiskDrive.class) {
            ((HardDiskDrive) product).setCapacity(productRequestDTO.getCapacity());
        }
        return product;
    }
}
