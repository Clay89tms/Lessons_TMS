package org.example.abstract_factory;

public class MersEngineServiceImpl implements EngineService {
    @Override
    public Engine createEngine() {
        return new Engine("Mers engine");
    }
}
