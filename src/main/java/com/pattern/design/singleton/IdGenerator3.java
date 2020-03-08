package com.pattern.design.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 *  单例模式 id生成器
 *  双重检查机制
 */
public class IdGenerator3 {
    private AtomicLong id = new AtomicLong(0);

    private static IdGenerator3 instance;

    private IdGenerator3(){}

    /**
     *   有人说instance 需要加上volatile,禁止指令重排
     *   理由是IdGenerator3被new出来，并赋值给instance之后，还没来得及初始化（执行构造函数代码逻辑），就被另外的线程用了
     *   实际上是，低版本才有这个问题，高版本已经在JDK内部解决了，new操作和初始化操作设计为原子操作
     *
     */
    public static IdGenerator3 getInstance(){
        if(instance == null){
            synchronized (IdGenerator3.class){
                if(instance == null){
                    instance = new IdGenerator3();
                }
            }
        }

        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }
}
