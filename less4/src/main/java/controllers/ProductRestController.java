package controllers;

import entities.Product;
import services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Product> showAllProduct(@ModelAttribute("product") Product product ){
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/LessThan/{cost}", method = RequestMethod.GET)
    public List<Product> showLessThan(@PathVariable(value = "cost") int cost){
        return productService.getLessThan(cost);
    }

    @RequestMapping(value = "/GreaterThan/{cost}", method = RequestMethod.GET)
    public List<Product> showGreaterThan(@PathVariable(value = "cost") int cost){
        return productService.getGreaterThan(cost);
    }
    @RequestMapping(value = "/Between", method = RequestMethod.GET)
    public List<Product> showBetween(@RequestParam int min, int max){
        return productService.getBetween(min,max);
    }

}