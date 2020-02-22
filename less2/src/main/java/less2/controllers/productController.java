package less2.controllers;

import less2.entites.Product;
import less2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class productController {
    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping("/resultForm")
    public String resultForm(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "productFormResult";
    }

    @RequestMapping("/productForm")
    public String productForm(Model uiModel) {
        Product product = productService.getDefaultProduct();
        uiModel.addAttribute("product", product);
        return "productForm";
    }

    @RequestMapping("/productAllForm")
    public String productAllForm(Model uiModel) {
        uiModel.addAttribute("products", productService.getAllProducts());
        return "AllProducts";
    }

    @RequestMapping(value = "/getProduct/{id}")
    @ResponseBody
    public Product getProduct(Model uiModel, @PathVariable(value = "id") int id) {
        Product product = productService.getProductById(id);
        return product;
    }
}
