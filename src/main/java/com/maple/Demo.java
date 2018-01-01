package com.maple;

public class Demo {

    public static void main(String[] args) {
        System.out.println(Demo.class.getClassLoader());
        ClassLoader loader = Demo.class.getClassLoader();
        while (loader!=null){
            System.out.println(loader);
            loader = loader.getParent();
        }
        System.out.println(loader);


        ClassLoader classLoader=ClassLoader.getSystemClassLoader();
        Thread thread0=new Thread();
        thread0.currentThread().setContextClassLoader(classLoader);
        Thread thread1=new Thread();
        thread1.currentThread().setContextClassLoader(classLoader);
        Thread thread2=new Thread();
        thread2.currentThread().setContextClassLoader(classLoader);

        System.out.println(thread0.getContextClassLoader());
        System.out.println(thread1.getContextClassLoader());
        System.out.println(thread2.getContextClassLoader());



    }
}
