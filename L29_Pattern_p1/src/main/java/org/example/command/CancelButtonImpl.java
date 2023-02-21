package org.example.command;

class CancelButtonImpl implements Button {
    @Override
    public void process() {
        System.out.println("Cancel button");
    }
}
