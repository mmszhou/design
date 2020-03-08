package com.pattern.design.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 *  单例模式 id生成器
 *  静态内部类
 */
public class IdGeneratorStaticInnerClass {

    private AtomicLong id = new AtomicLong(0);

    private IdGeneratorStaticInnerClass() {
    }

    /**
     * 当外部类加载的时候，不会创建SingletonHolder实例对象，只有调用下面getInstance方法时，SingletonHolder才会加载
     * 这个时候才会创建instance
     * instance的唯一性，创建过程的线程安全性，都由JVM保证
     * 该方法能保证线程安全，又保证了延迟加载
     */
    private static class SingletonHolder {
        private static final IdGeneratorStaticInnerClass instance = new IdGeneratorStaticInnerClass();
    }

    public static IdGeneratorStaticInnerClass getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
