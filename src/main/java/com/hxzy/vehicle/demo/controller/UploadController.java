package com.hxzy.vehicle.demo.controller;

import com.hxzy.vehicle.demo.util.DateUtil;
import com.hxzy.vehicle.demo.util.HMACSHA1;
import com.hxzy.vehicle.demo.util.StringUtil;
import com.hxzy.vehicle.demo.vo.FileVo;
import com.hxzy.vehicle.demo.vo.UploadResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


/**
 * @Description: Device File upload
 * @Author Allen
 * @Date 2023/8/8
 * @Version V1.0
 **/
@RestController
@RequestMapping("/fs")
@Slf4j
public class UploadController {

    @Value("${file.path}")
    private String rootPath;

    @PostMapping("/upload")
    public UploadResponse upload(FileVo vo, HttpServletRequest request){
        MultipartFile file = vo.getFile();
        String sign = vo.getSign();
        String nonce = vo.getNonce();
        String secret =  request.getHeader("secret");
        if(file != null && StringUtil.isNotEmpty(sign) && StringUtil.isNotEmpty(secret) && StringUtil.isNotEmpty(nonce)){
            String fileName = file.getOriginalFilename();
            if(fileName.contains("/")){
                fileName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("/")+1);
            }
            String data = fileName+nonce;
            String toSign = "";
            try {
                toSign = HMACSHA1.getSignature(data, secret);
            }catch (Exception e){
                e.printStackTrace();
                return new UploadResponse(101, "Signature exception ");
            }
            if(sign.equals(toSign)){
                try{
                    String todayStr = DateUtil.getTodayDate();
                    String path = rootPath + File.separator + todayStr;
                    File newFile = new File(path);
                    if(!newFile.exists()){
                        newFile.mkdirs();
                    }
                    String filePath = path + File.separator + fileName;
                    File saveFile = new File(filePath);
                    file.transferTo(saveFile);
                    return new UploadResponse(0, "success");
                }catch (IOException e){
                    e.printStackTrace();
                    return new UploadResponse(100, "Server IO exception");
                }
            }else{
                return new UploadResponse(101, "Signature error");
            }
        }else{
            return new UploadResponse(102, "Parameter exception");
        }
    }

}
