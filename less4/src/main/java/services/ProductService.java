package services;

import entities.Product;
import repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getLessThan(int cost){
        List <Product> products = productRepository.findByCostLessThanEqual(cost);
        return products;
    }

    public List<Product> getGreaterThan(int cost){
        List <Product> products = productRepository.findByCostGreaterThanEqual(cost);
        return products;
    }

    public List<Product> getBetween(int min,int max){
        List <Product> products = productRepository.findByCostBetween(min,max);
        return products;
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }


}
