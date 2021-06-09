package cn.quitomos.springclouddemo.productviewserviceribbon.contoller;

import cn.quitomos.springclouddemo.productviewserviceribbon.entity.Product;
import cn.quitomos.springclouddemo.productviewserviceribbon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @RequestMapping("/product")
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
