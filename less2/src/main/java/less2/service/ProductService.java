package less2.service;

import less2.entites.Product;
import less2.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepositories productRepositories;

    @Autowired
    public void setProductRepository(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }
    public Product getDefaultProduct(){  //который будет изначально отображатсья в форме
        Product product = new Product(0,"Название товара",0);
        return product;
    }
    public Product getProductById(int id) {
        Product product = productRepositories.findOneById(id);
        return product;
    }
    public void addProduct(int id, String title, int cost)
    {
        Product product = new Product(id, title, cost);
        productRepositories.addProduct(product);
    }

    public void addProduct(Product product)
    {
        productRepositories.addProduct(product);
    }
    public Product[] getAllProducts()
    {
        return productRepositories.getAllProducts();
    }

    public ProductService(){

    }
}
