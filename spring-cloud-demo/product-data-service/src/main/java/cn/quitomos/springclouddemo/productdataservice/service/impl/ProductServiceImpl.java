package cn.quitomos.springclouddemo.productdataservice.service.impl;

import cn.quitomos.springclouddemo.productdataservice.entity.Product;
import cn.quitomos.springclouddemo.productdataservice.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Value("${server.port}")
    String port;

    @Override
    public List<Product> listProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "product a from port" + port, 50));
        productList.add(new Product(2, "product b from port" + port, 50));
        productList.add(new Product(3, "product c from port" + port, 50));
        return productList;
    }
}
