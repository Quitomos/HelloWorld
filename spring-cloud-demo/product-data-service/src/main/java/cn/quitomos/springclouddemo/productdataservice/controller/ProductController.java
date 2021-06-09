package cn.quitomos.springclouddemo.productdataservice.controller;

import cn.quitomos.springclouddemo.productdataservice.entity.Product;
import cn.quitomos.springclouddemo.productdataservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public List<Product> listProducts() {
        return productService.listProducts();
    }


    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
