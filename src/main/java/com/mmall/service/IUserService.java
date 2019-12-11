package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * Created by Lenovo on 2019/12/10.
 */
public interface IUserService {
     ServerResponse<User> login(String username, String password);
     ServerResponse<String> register(User user);
     ServerResponse<String> checkValid(String str,String type);
}
