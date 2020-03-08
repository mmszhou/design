package com.pattern.design.singleton;


import java.util.concurrent.atomic.AtomicLong;

/**
 *  单例模式
 *  饿汉式
 *  应用场景2  id生成器
 */
public class IdGenerator {

    /**
     *   AtomicLong Java并发库中的一个原子变量类型
     *   线程安全的原子操作
     */
    private AtomicLong id = new AtomicLong(0);

    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator(){}

    public static IdGenerator getInstance(){
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println( IdGenerator.getInstance().getId());
        System.out.println( IdGenerator.getInstance().getId());

    }
}
