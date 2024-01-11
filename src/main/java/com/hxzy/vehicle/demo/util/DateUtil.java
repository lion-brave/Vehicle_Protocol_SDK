package com.hxzy.vehicle.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: TODO
 * @Author Allen
 * @Date 2023/8/8
 * @Version V1.0
 **/
public class DateUtil {

    public static String getTodayDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

}
