package com.hxzy.vehicle.demo.parse;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Component
public class FileMonitor {

    @Value("${file.path}")
    private String rootPath;
    @Resource
    FileListener fileListener;

    @PostConstruct
    public void initFileMonitor() {
        String rootDir = rootPath;
        Integer time = 5;
        long interval = TimeUnit.SECONDS.toMillis(time);
        FileAlterationObserver observer = new FileAlterationObserver(rootDir);
        observer.addListener(fileListener);
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
        try {
            monitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}