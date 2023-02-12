package org.example.proxy;

import java.lang.reflect.Proxy;

class MainApp {
     public static void main(String[] args) {

         Object o = Proxy.newProxyInstance(MainApp.class.getClassLoader(), new Class[]{ProxyInterface.class}, new MyInvocationHandler());
         ((ProxyInterface)o).print();

     }




}
