package com.pattern.design.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 *  单例模式 id生成器使用场景
 *  懒汉式 支持延迟加载
 *  加锁，并发度低
 */
public class IdGenerator2 {

    private AtomicLong id = new AtomicLong(0);

    private static IdGenerator2 instance;

    private IdGenerator2() {
    }

    public static synchronized IdGenerator2 getInstance() {
        if (instance == null) {
            instance = new IdGenerator2();
        }
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }
}
