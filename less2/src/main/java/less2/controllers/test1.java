package less2.controllers;

import less2.entites.Product;
import less2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class test1 {
    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }



    @RequestMapping("/")
    public String text(Model uiModel) {
        Product product = productService.getDefaultProduct();
        uiModel.addAttribute("product", product);
        return "productForm";
    }


    /*
    @RequestMapping("/5")
    public String hello0(Model uiModel,@RequestParam int id, String title, int cost) {
        productService.addProduct(id,title,cost);
        return "index";
    }

    @RequestMapping("/1/{id}")
    public String hello(Model uiModel,@PathVariable(value = "id") int id) {
        productService.addProduct(id,"123_"+id,3);
        return "index";
    }

    @RequestMapping(value = "/2/{id}")
    @ResponseBody
    public Product hello2(Model uiModel, @PathVariable(value = "id") int id) {
        Product product = productService.getProductById(id);
        System.out.println(product.getTitle());
        System.out.println(product);
        return product;
    }


    @RequestMapping("/3/")
    public String hello3(Model uiModel) {
        return "index";
    }

    @RequestMapping(value = "/start/{name}", method = RequestMethod.GET)
    public String hello4(Model uiModel, @PathVariable(value = "name") String name) {
        uiModel.addAttribute("name", name);
        return "index";
    }*/

}
