package org.example.command;

class OkButtonImpl implements Button {
    @Override
    public void process() {
        System.out.println("OK button");
    }
}
