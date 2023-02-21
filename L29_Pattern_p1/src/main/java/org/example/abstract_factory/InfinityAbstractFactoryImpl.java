package org.example.abstract_factory;

public class InfinityAbstractFactoryImpl implements AbstractFactory {
    @Override
    public EngineService getEngineService() {
        return new InfinityEngineServiceImpl();
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
