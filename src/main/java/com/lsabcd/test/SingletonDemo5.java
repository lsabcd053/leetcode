package com.lsabcd.test;

public class SingletonDemo5 {
    public static TestModel testModel = new TestModel();
    public  TestModel testModel2 = new TestModel();
    public final static TestModel testModel3 = new TestModel();

    public static int i = 123;

    static {
        System.out.println("static init");
    }
    private static class SingletonHolder{
        private static final SingletonDemo5 instance = new SingletonDemo5();
    }

    private SingletonDemo5(){
        System.out.println("init SingletonDemo5");
    }
    public static final SingletonDemo5 getInsatance(){
        return SingletonHolder.instance;
    }

    public static void print(){
        System.out.println("SingletonDemo5 static print");
    }

    public void test(){
        System.out.println("SingletonDemo5.test");
    }
}
