package org.example.decorator;

import java.util.ArrayList;
import java.util.List;

 class BufferedReadServiceImpl implements ReadService {

    private ReadService readService;

    List<Integer> buffer = new ArrayList<>();

    public BufferedReadServiceImpl(ReadService readService) {
        this.readService = readService;
    }

    @Override
    public int read() {
        if (buffer.isEmpty()) {
            int counter = 0;
            System.out.println("Buffer is Empty");
            for (int i = 0; i < 10; i++) {
                System.out.print(++counter + " ");
                int read = readService.read();
                buffer.add(read);
            }
        }
        System.out.println("return from buffer");
        return buffer.remove(0);
    }
 }
