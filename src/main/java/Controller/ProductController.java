package Controller;

import Entity.Product;
import Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable Long id) {
        return productService.getProductByID(id);
    }

    @PostMapping()
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("delete/{id}")
    @Transactional
    public List<Product> deleteProductByID(@PathVariable Long id) {
        productService.deleteById(id);
        return productService.getAllProducts();
    }

    @GetMapping("/search_by_min_cost")
    public List<Product> searchBiMinCost(@RequestParam(name = "min_cost") Integer minCost) {
        return productService.findAllByCostGreaterThanEqual(minCost);
    }

    @GetMapping("/search_by_max_cost")
    public List<Product> searchBiMaxCost(@RequestParam(name = "max_cost") Integer maxCost) {
        return productService.findAllByCostIsLessThanEqual(maxCost);
    }

    @GetMapping("/search_between")
    public List<Product> searchByCostBetween(@RequestParam(name = "min_cost") Integer minCost,
                                             @RequestParam(name = "max_cost") Integer maxCost) {
        return productService.findAllByCostBetween(minCost,maxCost);
    }
}
