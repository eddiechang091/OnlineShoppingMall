package com.mmall.service;

import com.mmall.common.ServerResponse;

/**
 * Created by Lenovo on 2019/12/26.
 */
public interface ICategoryService {
    ServerResponse<String> addCategory(String categoryName, Integer parentId);
    ServerResponse<String> setCategoryName(Integer categoryId,String categoryName);
}
