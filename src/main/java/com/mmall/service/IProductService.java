package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;

/**
 * Created by Lenovo on 2020/1/7.
 */
public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product);
    ServerResponse<String> setSaleStatus(Integer productId, Integer status);
}
