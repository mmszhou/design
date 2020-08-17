package com.pattern.design.chain2;

import java.util.ArrayList;
import java.util.List;

/**
 * 职责链模式
 * 使用数组容器
 */
public class HandlerChain {

    private List<IHandler> handlers = new ArrayList<>();

    public void addHandler(IHandler handler) {
        this.handlers.add(handler);
    }

    public void handle() {
        for (IHandler handler : handlers) {
            boolean result = handler.handle();
            if(result){
                break;
            }

        }
    }
}
