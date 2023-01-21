package org.example.abstract_factory;

public class LexusWheelServiceImpl implements WheelService {
    @Override
    public Wheel createWheel() {
        return new Wheel("Lexus wheel");
    }
}
