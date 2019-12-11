package com.mmall.common;

/**
 * Created by Lenovo on 2019/12/10.
 */
public enum  ResponseCode {
        SUCCESS(0,"SUCCESS"),
        ERROR(1,"ERROR"),
        NEED_LOGIN(10,"NEED_LOGIN"),
        ILLIGAL_ARGUMENT(2,"ILLIGAL_ARGUMENT");
        private final int code;
        private final String des;
        ResponseCode(int code,String des){
            this.code = code;
            this.des = des;
        }
        public int getCode(){
            return code;
        }
        public String getDes(){
            return des;
        }
}
