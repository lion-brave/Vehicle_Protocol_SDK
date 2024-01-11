package com.hxzy.vehicle.demo.vo;

import lombok.Data;

/**
 * @Description: TODO
 * @Author Allen
 * @Date 2023/8/8
 * @Version V1.0
 **/
@Data
public class UploadResponse {

    private int retCode;
    private String message;

    public UploadResponse(int retCode, String message){
        this.retCode = retCode;
        this.message = message;
    }

}
