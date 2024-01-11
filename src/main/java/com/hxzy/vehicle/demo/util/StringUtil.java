package com.hxzy.vehicle.demo.util;

/**
 * @Description: TODO
 * @Author Allen
 * @Date 2023/8/8
 * @Version V1.0
 **/
public class StringUtil {

    public static boolean isNotEmpty(String str){
        if(str != null && !"".equals(str)){
            return true;
        }
        return false;
    }

}
