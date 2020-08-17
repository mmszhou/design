package com.pattern.design.chain;

public class HandlerChain {

    private Handler head = null;
    private Handler tail = null;

    public void addHeadler(Handler handler){
        if(head == null){
            head = handler;
            tail = handler;
            return;
        }

        tail.setSuccessor(handler);
        tail = handler;

    }

    public void handler(){
        if(head != null){
            head.handle();
        }
    }

}
