package org.example.command;

class PrintButtonImpl implements Button {
    @Override
    public void process() {
        System.out.println("Print button");
    }
}
