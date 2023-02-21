package org.example;

public enum Position {
    DIRECTOR(2.5),
    WORKER(1);

    double koef;

    Position(double koef) {
        this.koef = koef;
    }
}
