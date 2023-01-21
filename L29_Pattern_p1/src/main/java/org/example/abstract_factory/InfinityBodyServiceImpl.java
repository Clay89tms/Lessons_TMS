package org.example.abstract_factory;

public class InfinityBodyServiceImpl implements BodyService {
    @Override
    public Body createBody() {
        return new Body("Infinity body");
    }
}
