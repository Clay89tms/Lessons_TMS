package org.example.abstract_factory;

public interface AbstractFactory {

    EngineService getEngineService();

    BodyService getBodyService();

    WheelService getWheelService();

}
