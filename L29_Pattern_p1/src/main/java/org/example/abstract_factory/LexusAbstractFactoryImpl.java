package org.example.abstract_factory;

public class LexusAbstractFactoryImpl implements AbstractFactory {
    @Override
    public EngineService getEngineService() {
        return new LexusEngineServiceImpl();
    }

    @Override
    public BodyService getBodyService() {
        return new InfinityBodyServiceImpl();
    }

    @Override
    public WheelService getWheelService() {
        return new LexusWheelServiceImpl();
    }
}
