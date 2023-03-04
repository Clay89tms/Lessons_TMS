package org.example.strategy;

public class DifMathServiceImpl implements MathService {
    @Override
    public int calc(int v1, int v2) {
        return v1 - v2;
    }
}
