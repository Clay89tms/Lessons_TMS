package org.example.abstract_factory;

public class LexusEngineServiceImpl implements EngineService {
    @Override
    public Engine createEngine() {
        return new Engine("Lexus engine");
    }
}
