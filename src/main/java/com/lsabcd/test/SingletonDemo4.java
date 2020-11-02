package com.lsabcd.test;

public class SingletonDemo4 {
    private static SingletonDemo4 instance = null;
    static{
        System.out.println("SingletonDemo4 static");
        instance = new SingletonDemo4();
    }
    private SingletonDemo4(){
        System.out.println("init SingletonDemo4");
    }
    public static SingletonDemo4 getInstance(){
        return instance;
    }

    public static void print(){
        System.out.println("SingletonDemo4 static print");
    }
}
