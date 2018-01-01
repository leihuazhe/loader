package com.maple.test;

public class A {

    public void action(Object obj){
        System.out.println("obj :"+obj.getClass());
        System.out.println("obj :"+obj.getClass().getClassLoader());
    }
}
