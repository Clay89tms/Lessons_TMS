package org.example.state;

import jdk.dynalink.Operation;
import lombok.Setter;

@Setter
class MathService {

    private Operation operation = Operation.DIF;

    public int calc(int v1, int v2) {
        int result = 0;
        switch (operation) {
            case SUM:
                result = v1 + v2;
                break;
            case DEV:
                result = v1 / v2;
                break;
            case MUL:
                result = v1 * v2;
                break;
            default:
                result = v1 - v2;
                break;
        }
        return result;
    }

    public enum Operation {
        SUM,
        DEV,
        MUL,
        DIF
    }

}
