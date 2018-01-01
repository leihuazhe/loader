package com.maple;

import com.maple.cl.DemoFather;

import java.lang.reflect.Method;

public class Demo2 extends DemoFather{




    public static void main(String[] args) throws Exception {
//        MapleClassLoader mc = new MapleClassLoader(Thread.currentThread().getContextClassLoader(),"E:\\Workspaces\\loader\\target\\classes\\");
        MapleClassLoader mc = new MapleClassLoader(Thread.currentThread().getContextClassLoader(),"E:\\Workspaces\\classes\\");

        Class<?> clazz = mc.loadClass("com.maple.Demo1");
        Object obj = (Object)clazz.newInstance();
        DemoFather df = (DemoFather) obj;
        System.out.println(obj instanceof DemoFather);
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(DemoFather.class.getClassLoader());
        Method method= clazz.getDeclaredMethod("addNum");
        method.setAccessible(true);
        method.invoke(obj);
        method.invoke(obj);





        System.out.println("load: "+ obj.getClass());
        System.out.println("local: "+ Demo2.NUM);
        System.out.println(obj instanceof Demo2);
    }

    private static int NUM = 1;

    private static Integer addNum(){
        int num = NUM++;
        System.out.println("--->"+num);
        return num;
    }



}
