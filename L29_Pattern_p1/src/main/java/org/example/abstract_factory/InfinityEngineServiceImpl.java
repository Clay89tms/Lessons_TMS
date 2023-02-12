package org.example.abstract_factory;

public class InfinityEngineServiceImpl implements EngineService {
    @Override
    public Engine createEngine() {
        return new Engine("Infinity engine");
    }
}
