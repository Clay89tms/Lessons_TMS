package org.example.abstract_factory;

public class MersBodyServiceImpl implements BodyService {
    @Override
    public Body createBody() {
        return new Body("Mers body");
    }
}
