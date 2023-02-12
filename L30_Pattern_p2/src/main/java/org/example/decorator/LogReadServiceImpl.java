package org.example.decorator;

public class LogReadServiceImpl implements ReadService {

    private ReadService readService;

    public LogReadServiceImpl(ReadService readService) {
        this.readService = readService;
    }

    @Override
    public int read() {
        long start = System.currentTimeMillis();
        int read = readService.read();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.println("read time is " + (end - start));
        return read;
    }
}
