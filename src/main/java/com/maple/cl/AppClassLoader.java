package com.maple.cl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * App Class Loader
 *
 * @author craneding
 * @date 16/1/28
 */
public class AppClassLoader extends ClassLoader {

    private String path = "E:\\Workspaces\\loader\\target\\classes\\";

    public AppClassLoader(String path) {
        super(ClassLoader.getSystemClassLoader());
        this.path = path;
    }

    public AppClassLoader(ClassLoader parent,String path) {
        super(parent);
        this.path = path;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        if (name.startsWith("com.maple.test.S") || name.startsWith("com.isuwang.org.apache.thrift") || name.startsWith("com.isuwang.dapeng.transaction.api")
                || name.startsWith("com.google.gson"))
            return ClassLoaderManager.shareClassLoader.loadClass(name);


        try {
            Class<?> c = findLoadedClass(name);
            if(c==null){
                String fileName = name.replaceAll("\\.", "\\/");
                FileInputStream is;
                try {
                    is = new FileInputStream(new File(path + fileName + ".class"));
                } catch (Exception e) {
                    is = null;
                }

                if (is == null) {
                    return super.loadClass(name);
                }

                ByteArrayOutputStream bos = new ByteArrayOutputStream();

                int b;

                while ((b = is.read()) != -1) {
                    bos.write(b);
                }

                byte[] data = bos.toByteArray();

                return defineClass(name, data, 0, data.length);
            }
            return c;
        } catch (Exception e) {
            throw new ClassNotFoundException(name);
        }

    }
}
