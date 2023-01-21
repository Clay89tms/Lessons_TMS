package org.example.abstract_factory;

public class MersWheelServiceImpl implements WheelService {
    @Override
    public Wheel createWheel() {
        return new Wheel("Mers wheel");
    }
}
