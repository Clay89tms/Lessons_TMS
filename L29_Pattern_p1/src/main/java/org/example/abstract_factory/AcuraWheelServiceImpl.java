package org.example.abstract_factory;

public class AcuraWheelServiceImpl implements WheelService {
    @Override
    public Wheel createWheel() {
        return new Wheel("Acura wheel");
    }
}
