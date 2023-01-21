package org.example.abstract_factory;

public class AcuraAbstractFactoryImpl implements AbstractFactory {
    @Override
    public EngineService getEngineService() {
        return new AcuraEngineServiceImpl();
    }

    @Override
    public BodyService getBodyService() {
        return new AcuraBodyServiceImpl();
    }

    @Override
    public WheelService getWheelService() {
        return new AcuraWheelServiceImpl();
    }
}
