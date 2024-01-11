package com.hxzy.vehicle.demo.parse.service.impl;

import com.hxzy.vehicle.demo.parse.service.AsyncService;
import com.hxzy.vehicle.demo.vo.DevData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {

    @Async("asyncServiceExecutor")
    @Override
    public void executeAsync(String filePath) {
        log.info("File processing start：" + filePath);
        long startTime = System.currentTimeMillis();
        try{
            String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
            String centerBoxSn = fileName.split("-")[0];
            List<DevData> datas = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line ;
            while((line = reader.readLine()) != null){
                if(line.contains("$UPLOAD")){
                    String msgStr = line.substring(19);
                    log.info(msgStr);
                    try {
                        DevData msgVo = new DevData(msgStr);
                        msgVo.setDevSn(centerBoxSn);
                        datas.add(msgVo);
                    }catch (Exception e){
                        log.info("Data exception：" + line);
                    }
                }
            }
            reader.close();
            //数Data entry

            new File(filePath).delete();
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("File finish：" + filePath + ", cost time: " + (System.currentTimeMillis() - startTime) + " ms");
    }

}