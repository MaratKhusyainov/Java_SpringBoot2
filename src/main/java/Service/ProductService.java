package Service;

import Entity.Product;
import Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductByID(Long id) {
        return productRepository.findById(id).get();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllByCostGreaterThanEqual(Integer minCost) {
        return productRepository.findAllByCostGreaterThanEqual(minCost);
    }
    public List<Product> findAllByCostIsLessThanEqual(Integer maxCost) {
        return productRepository.findAllByCostIsLessThanEqual(maxCost);
    }
    public List<Product> findAllByCostBetween(Integer minCost,Integer maxCost ) {
        return productRepository.findAllByCostBetween(minCost,maxCost);
    }
}
