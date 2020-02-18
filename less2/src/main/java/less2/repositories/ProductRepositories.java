package less2.repositories;

import less2.entites.Product;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductRepositories {
    private Map<Integer,Product>  products = new HashMap<>();
    //реализовал через хешмап, чтобы можно было без циклов искать товар.
    public Product findOneById(int id) {
        return products.get(id);
    }
    public void addProduct(Product product){
        products.put(product.getId(),product);
        System.out.println("Added new product. N "+products.size());
    }
    public Product[] getAllProducts()
    {
        Product[] productsArray = new Product[products.size()];
        int i =0;
        for (Product product:products.values()) {
            productsArray[i++]=product;
        }
        return productsArray;
    }

}
