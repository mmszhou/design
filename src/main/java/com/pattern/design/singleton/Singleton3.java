package com.pattern.design.singleton;

/**
 * 单例模式
 * 解决单例不支持有参数的构造函数
 * 将参数放到另外一个全局变量中
 */
public class Singleton3 {

    private static Singleton3 instance = null;
    private final int paramA;
    private final int paramB;

    private Singleton3() {
        this.paramA = Config.PARAM_A;
        this.paramB = Config.PARAM_B;
    }

    public static synchronized Singleton3 getInstance(int paramA,int paramB){
        if(instance == null){
            instance = new Singleton3();
        }
        return  instance;
    }
}

