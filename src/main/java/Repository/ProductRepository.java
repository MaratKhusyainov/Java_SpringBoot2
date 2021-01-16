package Repository;

import Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByCostGreaterThanEqual(int minCost);
    List<Product> findAllByCostIsLessThanEqual(int maxCost);
    List<Product> findAllByCostBetween(int minCost, int maxCost);
}