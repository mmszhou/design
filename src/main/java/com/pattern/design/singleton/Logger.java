package com.pattern.design.singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *  单例模式test
 *  饿汉式
 *  应用场景1 日志
 *  所有线程共享一个Logger对象
 */
public class Logger {
    private FileWriter writer;

    private static final Logger instance = new Logger();

    private Logger(){
        File file = new File("/log.txt");
        try {
            writer = new FileWriter(file,true);
        } catch (IOException e) {

        }
    }

    public static Logger getInstance(){
        return instance;
    }

    public void log(String message){
        try {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
