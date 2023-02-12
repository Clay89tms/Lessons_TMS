package org.example.command;

class PasteButtonImpl implements Button {
    @Override
    public void process() {
        System.out.println("Paste button");
    }
}
