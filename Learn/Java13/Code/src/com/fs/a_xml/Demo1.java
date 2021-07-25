package com.fs.a_xml;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author fs
 */
public class Demo1 {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException {
        /*
        快捷键：
            new Constructor().var
            Method().var
         */
        ArrayList<String> list = new ArrayList<>();

        /*
        快捷键：
            l.a => 选择
         */
        list.add("老王");

        /*
        快捷键:
            集合/数组.iter

         */
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Class cls = Class.forName("com.fs.a_xml.Person");
        /*
        快捷键:
            Alt + Enter
            Alt + /
         */
        Method setId = cls.getMethod("setId", int.class);
    }
}




















