package org.example;

public class Singleton2 {
    public Singleton2() {
    }
    private static class SingletonHolder{
        public static final Singleton2 holder_instance = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return SingletonHolder.holder_instance;
    }
}
