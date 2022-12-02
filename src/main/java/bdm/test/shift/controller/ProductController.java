package bdm.test.shift.controller;

import bdm.test.shift.controller.dto.ProductRequestDTO;
import bdm.test.shift.controller.dto.ProductResponseDTO;
import bdm.test.shift.entity.Product;
import bdm.test.shift.mapper.ProductMapper;
import bdm.test.shift.mapper.ProductResponseDTOMapper;
import bdm.test.shift.service.ProductService;
import bdm.test.shift.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final ProductResponseDTOMapper productResponseDTOMapper;
    private final ProductValidator productValidator;

    @Autowired
    public ProductController(ProductService productService, ProductValidator productValidator, ProductMapper productMapper, ProductResponseDTOMapper productResponseDTOMapper, ProductValidator productValidator1) {
        this.productService = productService;
        this.productMapper = productMapper;
        this.productResponseDTOMapper = productResponseDTOMapper;
        this.productValidator = productValidator1;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        Product product = productValidator.checkAndIdentifyRequest(productRequestDTO);
        return productService.addProduct(productMapper.mapToProduct(productRequestDTO, product));
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        Product product = productValidator.checkAndIdentifyRequest(productRequestDTO);
        return productService.updateProduct(productMapper.mapToProduct(productRequestDTO, product));
    }

    @DeleteMapping("/products/{ns}")
    public ProductResponseDTO deleteProduct(@PathVariable Long ns) {
        return (productResponseDTOMapper.mapToProductResponseDTO(productService.deleteProduct(ns)));
    }

    @GetMapping("/productsByType/{requiredType}")
    public List<ProductResponseDTO> getAllByType(@PathVariable String requiredType) {
        productValidator.checkInputRequiredType(requiredType);
        return productResponseDTOMapper.mapToListProductResponseDTO(productService.getAllByType(requiredType));
    }

    @GetMapping("/products/{ns}")
    public ProductResponseDTO getProduct(@PathVariable Long ns) {
        return productResponseDTOMapper.mapToProductResponseDTO(productService.getProduct(ns));
    }
}
