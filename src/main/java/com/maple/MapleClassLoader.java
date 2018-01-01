package com.maple;

import java.io.*;

public class MapleClassLoader extends ClassLoader {

    private String path = "E:\\Workspaces\\loader\\target\\classes\\";

    public MapleClassLoader(String path){
        this.path = path ;
    }

    public MapleClassLoader(ClassLoader parent,String path){
        super(parent);
        this.path = path;
    }


    /*@Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
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
        } catch (Exception e) {
            throw new ClassNotFoundException(name);
        }
    }*/


    /*private byte[] loadClassData(String name) {
        try {
            name = name.replaceAll(".", "\\");
            FileInputStream is = new FileInputStream(new File(path + name + ".class"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int b;
            while ((b = is.read()) != -1) {
                bos.write(b);
            }
            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
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
        } catch (Exception e) {
            throw new ClassNotFoundException(name);
        }
    }
}
