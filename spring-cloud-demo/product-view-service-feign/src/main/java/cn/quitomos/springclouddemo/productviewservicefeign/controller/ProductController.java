package cn.quitomos.springclouddemo.productviewservicefeign.controller;

import cn.quitomos.springclouddemo.productviewservicefeign.entity.Product;
import cn.quitomos.springclouddemo.productviewservicefeign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @GetMapping("/product")
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
