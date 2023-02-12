package org.example.abstract_factory;

public class MersAbstractFactoryImpl implements AbstractFactory {
    @Override
    public EngineService getEngineService() {
        return new MersEngineServiceImpl();
    }

    @Override
    public BodyService getBodyService() {
        return new MersBodyServiceImpl();
    }

    @Override
    public WheelService getWheelService() {
        return new MersWheelServiceImpl();
    }
}
