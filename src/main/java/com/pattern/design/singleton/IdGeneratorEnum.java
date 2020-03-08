package com.pattern.design.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 单例模式 id生成器
 * 枚举
 * 枚举本身的特性，保证了实例创建的安全性和唯一性
 */
public enum IdGeneratorEnum {

    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId(){
        return id.incrementAndGet();
    }
}
