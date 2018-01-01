package com.maple.main;

import com.maple.cl.AppClassLoader;
import com.maple.cl.ClassLoaderManager;
import com.maple.cl.ShareClassLoader;
import com.maple.test.A;
import com.maple.test.B;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        ShareClassLoader sc = new ShareClassLoader(Thread.currentThread().getContextClassLoader(),"E:\\Workspaces\\classes\\");
        AppClassLoader ac = new AppClassLoader(Thread.currentThread().getContextClassLoader(),"E:\\Workspaces\\classes\\");
        ClassLoaderManager.shareClassLoader = sc;

        Class<?> clazzA = sc.loadClass("com.maple.test.A");
        Class<?> clazzB = ac.loadClass("com.maple.test.B");



        System.out.println("clazzA  :"+clazzA.getClassLoader());
        System.out.println("clazzB  :"+clazzB.getClassLoader());

        Object objA = (Object)clazzA.newInstance();

        A a = new A();

        Object objB = (Object)clazzB.newInstance();

        System.out.println(objA instanceof A);

        System.out.println("extends     :"+clazzA.isAssignableFrom(clazzB));

        System.out.println("extends     :"+A.class.isAssignableFrom(B.class));

        Method m = clazzA.getMethod("action",Object.class);

        m.invoke(objA,objB);

        Class<?> clazzB_S = sc.loadClass("com.maple.test.B");

        System.out.println(clazzB_S.getClassLoader());

        System.out.println(clazzB == clazzB_S);

    }
}
