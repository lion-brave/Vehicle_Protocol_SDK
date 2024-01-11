package com.hxzy.vehicle.demo.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: TODO
 * @Author Allen
 * @Date 2023/8/8
 * @Version V1.0
 **/
@Data
public class FileVo {

    private MultipartFile file;
    private String nonce;
    private String sign;

}
