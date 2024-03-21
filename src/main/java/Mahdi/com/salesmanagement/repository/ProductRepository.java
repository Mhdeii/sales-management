package Mahdi.com.salesmanagement.repository;

import Mahdi.com.salesmanagement.service.ProductService;
import Mahdi.com.salesmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductService, Long> {
}
