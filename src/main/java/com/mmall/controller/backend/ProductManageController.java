package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.pojo.User;
import com.mmall.service.IProductService;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Lenovo on 2020/1/7.
 */
@Controller
@RequestMapping("/manage/product")
public class ProductManageController {
    @Autowired
    IUserService iUserService;
    @Autowired
    IProductService iProductService;
    @RequestMapping("save.do")
    @ResponseBody
    public ServerResponse<String> productSave(HttpSession session,Product product){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登陆，请以管理员身份登陆！");
        }
        if (iUserService.checkAdminRole(user).isSuccess()){
            return iProductService.saveOrUpdateProduct(product);
        }
        return ServerResponse.createByErrorMessage("不是管理员，没有权限登陆！");

    }
    @RequestMapping("set_sale_status.do")
    @ResponseBody
    public ServerResponse<String> setSaleStatus(HttpSession session,Integer productId, Integer status){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登陆，请以管理员身份登陆！");
        }
        if (iUserService.checkAdminRole(user).isSuccess()){
            return iProductService.setSaleStatus(productId,status);
        }
        return ServerResponse.createByErrorMessage("不是管理员，没有权限登陆！");

    }
}
