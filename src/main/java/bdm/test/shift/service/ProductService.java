package bdm.test.shift.service;

import bdm.test.shift.entity.Product;
import bdm.test.shift.exception.IllegalProductException;
import bdm.test.shift.exception.ProductNotFoundException;
import bdm.test.shift.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        if (productRepository.findById(product.getNs()).isPresent()) {
            throw new IllegalProductException();
        }
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        if (!productRepository.findById(product.getNs()).isPresent()) {
            throw new ProductNotFoundException();
        }
        return productRepository.save(product);
    }

    public Product deleteProduct(Long ns) {
        Product product = getProduct(ns);
        productRepository.deleteById(ns);
        return product;
    }

    public List<Product> getAllByType(String requiredType) {
        return productRepository.findAllByType(requiredType);
    }

    public Product getProduct(Long ns) {
        return productRepository.findById(ns).orElseThrow(ProductNotFoundException::new);
    }
}
