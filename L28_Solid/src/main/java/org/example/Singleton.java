package org.example;

public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static synchronized Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
