package com.lsabcd.test;

public class TestMain {


    public static void main(String[] args) throws ClassNotFoundException {

        test4();

        System.out.println("-----");

        test5();
    }

    public static void test5() throws ClassNotFoundException {

//        System.out.println(SingletonDemo5.i == 1);
//        SingletonDemo5.print();

//        SingletonDemo5 s = SingletonDemo5.getInsatance();
//        s.test();
        System.out.println("-----");
    }


    public static void test4() throws ClassNotFoundException {

        SingletonDemo4.print();

//        SingletonDemo4 s = SingletonDemo4.getInstance();
//        s.test();
        System.out.println("-----");
    }
}
