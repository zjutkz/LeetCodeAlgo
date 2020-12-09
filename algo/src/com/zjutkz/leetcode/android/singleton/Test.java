package com.zjutkz.leetcode.android.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {

        Enum e = Enum.INSTANCE;
        System.out.println(e);

        Enum e2 = (Enum) reflect(Enum.class);
        System.out.println(e2);

        Enum enum3 = (Enum) stream(e, "enum");
        System.out.println(enum3);
    }

    private static Object reflect(Class clz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Hungry> c = clz.getDeclaredConstructor(String.class,int.class);
        c.setAccessible(true);
        return c.newInstance("INSTANCE", 0);
    }

    private static Object stream(Object object, String fileName) throws IOException, ClassNotFoundException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(object);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        return in.readObject();
    }
}
