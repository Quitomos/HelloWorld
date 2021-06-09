package cn.quitomos.springclouddemo.productviewservicefeign.service;

import cn.quitomos.springclouddemo.productviewservicefeign.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> listProducts();
}
