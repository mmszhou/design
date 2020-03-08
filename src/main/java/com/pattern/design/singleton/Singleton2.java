package com.pattern.design.singleton;

/**
 * 单例模式
 * 解决单例不支持有参数的构造函数
 * 参数放到 getIntance()
 */
public class Singleton2 {

    private static Singleton2 instance = null;
    private final int paramA;
    private final int paramB;

    private Singleton2(int paramA,int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public static synchronized Singleton2 getInstance(int paramA,int paramB){
      /*  if(instance == null){
            instance = new Singleton2(paramA,paramB);
        }
        return  instance;*/

        //解决两次getInstance初始化不同的值，但构造函数的入参不变的问题
        if (instance == null) {
            instance = new Singleton2(paramA, paramB);
        } else if (instance.paramA == paramA && instance.paramB == paramB) {
            return instance;
        } else {
            instance = new Singleton2(paramA, paramB);
        }
        return instance;
    }

    //Singleton singleton = Singleton.getInstance(10, 50);
}
