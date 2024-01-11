package com.hxzy.vehicle.demo.parse;

import com.hxzy.vehicle.demo.parse.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;

/**
 * File listener
 */
@Component
@Slf4j
public class FileListener extends FileAlterationListenerAdaptor {

    @Resource
    AsyncService asyncService;

    @Override
    public void onStart(FileAlterationObserver observer) {
        //System.out.println("Start monitor：");
    }
    @Override
    public void onDirectoryCreate(File directory) {
        //System.out.println("A new folder is generated："+directory.getName());
    }
    @Override
    public void onDirectoryChange(File directory) {
        //System.out.println("The contents of a folder have changed："+directory.getName());
    }
    @Override
    public void onDirectoryDelete(File directory) {
        //System.out.println("A folder has been deleted："+directory.getName());
    }

    @Override
    public void onFileCreate(File file){
        //log.info("A new file is generated："+file.getAbsolutePath());
        asyncService.executeAsync(file.getAbsolutePath());
    }

    @Override
    public void onFileChange(File file){
        //log.info("A file has been modified："+file.getAbsolutePath());
    }

    @Override
    public void onFileDelete(File file){
        //log.info("A file has been deleted："+file.getAbsolutePath());
    }

    @Override
    public void onStop(FileAlterationObserver observer){
        // System.out.println("Listening stop");
    }
}
