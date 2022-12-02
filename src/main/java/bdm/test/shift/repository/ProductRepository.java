package bdm.test.shift.repository;

import bdm.test.shift.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByType(String requiredType);
}
