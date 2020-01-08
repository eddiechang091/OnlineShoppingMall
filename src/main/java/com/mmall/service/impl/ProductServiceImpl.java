package com.mmall.service.impl;

import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.dao.ProductMapper;
import com.mmall.pojo.Product;
import com.mmall.service.IProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2020/1/7.
 */
@Service("iProductService")
public class ProductServiceImpl implements IProductService {
        @Autowired
        ProductMapper productMapper;
        public ServerResponse saveOrUpdateProduct(Product product){
            if (product != null){
                if (StringUtils.isNotBlank(product.getSubImages())){
                    String[] subImageArray = product.getSubImages().split(",");
                    if (subImageArray.length>0){
                        product.setMainImage(subImageArray[0]);
                    }
                }
                if (product.getId()!=null){
                    int countRow = productMapper.updateByPrimaryKey(product);
                    if (countRow>0){
                        return ServerResponse.createBySuccessMessage("更新产品成功！");
                    }
                    return ServerResponse.createByErrorMessage("更新产品失败！");

                }else {
                    int countRow = productMapper.insert(product);
                    if (countRow>0){
                        ServerResponse.createBySuccessMessage("新增产品成功！");
                    }
                    return ServerResponse.createByErrorMessage("新增产品失败！");
                }

            }
            return ServerResponse.createByErrorMessage("新增或者更新产品参数错误！");

        }

    public ServerResponse<String> setSaleStatus(Integer productId, Integer status){
        if (productId == null || status == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLIGAL_ARGUMENT.getCode(),ResponseCode.ILLIGAL_ARGUMENT.getDes());
        }
        Product product = new Product();
        product.setId(productId);
        product.setStatus(status);
        int rowCount = productMapper.updateByPrimaryKeySelective(product);
        if (rowCount>0){
            return ServerResponse.createBySuccessMessage("修改产品销售状态成功！");
        }
        return ServerResponse.createByErrorMessage("修改产品销售状态失败！");
    }
}
