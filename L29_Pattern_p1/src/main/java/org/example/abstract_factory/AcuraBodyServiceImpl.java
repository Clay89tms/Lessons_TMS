package org.example.abstract_factory;

public class AcuraBodyServiceImpl implements BodyService {
    @Override
    public Body createBody() {
        return new Body("Acura body");
    }
}
