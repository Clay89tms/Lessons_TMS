package org.example.strategy;

public class SumMathServiceImpl implements MathService {

    @Override
    public int calc(int v1, int v2) {
        return v1 + v2;
    }
}
