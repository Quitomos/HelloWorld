package cn.quitomos.springclouddemo.productviewservicefeign.client;

import cn.quitomos.springclouddemo.productviewservicefeign.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "PRODUCT-DATA-SERVICE")
public interface ProductClientFeign {

    @GetMapping("/product")
    public List<Product> listProducts();
}
