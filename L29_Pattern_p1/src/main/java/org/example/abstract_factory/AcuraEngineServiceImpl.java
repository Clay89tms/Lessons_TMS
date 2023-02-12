package org.example.abstract_factory;

public class AcuraEngineServiceImpl implements EngineService {
    @Override
    public Engine createEngine() {
        return new Engine("Acura engine");
    }
}
