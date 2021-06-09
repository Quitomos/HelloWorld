package cn.quitomos.springclouddemo.productviewserviceribbon.service.impl;

import cn.quitomos.springclouddemo.productviewserviceribbon.client.ProductClientRibbon;
import cn.quitomos.springclouddemo.productviewserviceribbon.entity.Product;
import cn.quitomos.springclouddemo.productviewserviceribbon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductClientRibbon productClientRibbon;

    @Override
    public List<Product> listProducts() {
        return productClientRibbon.listProducts();
    }

    @Autowired
    public void setProductClientRibbon(ProductClientRibbon productClientRibbon) {
        this.productClientRibbon = productClientRibbon;
    }
}
