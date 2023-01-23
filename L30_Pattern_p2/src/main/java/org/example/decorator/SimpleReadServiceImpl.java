package org.example.decorator;

import java.util.Random;

 class SimpleReadServiceImpl implements ReadService {
    @Override
    public int read() {
        int i = new Random().nextInt();
        System.out.println("return from random = " + i);
        return i;
    }

 }
