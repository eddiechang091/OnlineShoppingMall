package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

/**
 * Created by Lenovo on 2019/12/26.
 */
public interface ICategoryService {
    ServerResponse<String> addCategory(String categoryName, Integer parentId);
    ServerResponse<String> setCategoryName(Integer categoryId,String categoryName);
    ServerResponse<List<Category>> findCategoryParallelList(Integer categoryId);
    ServerResponse<List<Integer>> findCategoryAndDeepChildrenList(Integer categoryId);
}
