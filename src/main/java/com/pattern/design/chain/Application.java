package com.pattern.design.chain;
// 职责链
public class Application {

    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHeadler(new HandlerA());
        chain.addHeadler(new HandlerB());
        chain.handler();

    }
}
