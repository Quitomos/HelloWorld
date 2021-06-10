package cn.quitomos.springclouddemo.productviewservicefeign.controller;

import cn.quitomos.springclouddemo.productviewservicefeign.entity.Product;
import cn.quitomos.springclouddemo.productviewservicefeign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    private ProductService productService;

    @Value("${version}")
    private String version;

    @GetMapping("/product")
    public Map<String, Object> listProducts() {
        Map<String, Object> ret = new HashMap<>();
        ret.put("version", version);
        ret.put("products", productService.listProducts());
        return ret;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
