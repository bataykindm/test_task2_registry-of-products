package bdm.test.shift.mapper;

import bdm.test.shift.controller.dto.*;
import bdm.test.shift.entity.*;
import bdm.test.shift.exception.IllegalTypeOfProductException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductResponseDTOMapper {

    public ProductResponseDTO mapToProductResponseDTO(Product product) {

        ProductResponseDTO productResponseDTO = identifyTypeOfProduct(product);

        productResponseDTO.setNs(product.getNs());
        productResponseDTO.setManufacture(product.getManufacture());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setAmount(product.getAmount());
        productResponseDTO.setType(product.getType());

        return setPropertyToProductResponseDTOAccordingType(productResponseDTO, product);
    }

    private ProductResponseDTO identifyTypeOfProduct(Product product) {
        if (product.getClass() == Computer.class) {
            return new ComputerResponseDTO();
        }
        if (product.getClass() == Laptop.class) {
            return new LaptopResponseDTO();
        }
        if (product.getClass() == Monitor.class) {
            return new MonitorResponseDTO();
        }
        if (product.getClass() == HardDiskDrive.class) {
            return new HardDiskDriveResponseDTO();
        }
        throw new IllegalTypeOfProductException();
    }

    private ProductResponseDTO setPropertyToProductResponseDTOAccordingType(ProductResponseDTO productResponseDTO, Product product) {
        if (product.getType().equals("computer")) {
            String formFactor = ((Computer) product).getFormFactor();
            ((ComputerResponseDTO) productResponseDTO).setFormFactor(formFactor);
        }
        if (product.getType().equals("laptop")) {
            Integer size = ((Laptop) product).getSize();
            ((LaptopResponseDTO) productResponseDTO).setSize(size);
        }
        if (product.getType().equals("monitor")) {
            Float diagonal = ((Monitor) product).getDiagonal();
            ((MonitorResponseDTO) productResponseDTO).setDiagonal(diagonal);
        }
        if (product.getType().equals("hdd")) {
            Integer capacity = ((HardDiskDrive) product).getCapacity();
            ((HardDiskDriveResponseDTO) productResponseDTO).setCapacity(capacity);
        }
        return productResponseDTO;
    }

    public List<ProductResponseDTO> mapToListProductResponseDTO(List<Product> products) {
        return products.stream().map(this::mapToProductResponseDTO).collect(Collectors.toList());
    }
}
