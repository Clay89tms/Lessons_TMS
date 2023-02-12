package org.example.command;

class CopyButtonImpl implements Button {
    @Override
    public void process() {
        System.out.println("Copy button");
    }
}
