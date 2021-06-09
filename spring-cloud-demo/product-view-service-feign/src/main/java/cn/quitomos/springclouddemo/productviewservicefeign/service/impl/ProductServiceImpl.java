package cn.quitomos.springclouddemo.productviewservicefeign.service.impl;

import cn.quitomos.springclouddemo.productviewservicefeign.client.ProductClientFeign;
import cn.quitomos.springclouddemo.productviewservicefeign.entity.Product;
import cn.quitomos.springclouddemo.productviewservicefeign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductClientFeign productClientFeign;

    @Override
    public List<Product> listProducts() {
        return productClientFeign.listProducts();
    }

    @Autowired
    public void setProductClientFeign(ProductClientFeign productClientFeign) {
        this.productClientFeign = productClientFeign;
    }
}
