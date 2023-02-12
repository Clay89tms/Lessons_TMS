package org.example.state;

class MainState {
    public static void main(String[] args) {
        MathService mathService = new MathService();
        int v1 = 10;
        int v2 = 5;

        System.out.println(mathService.calc(v1, v2));

        mathService.setOperation(MathService.Operation.SUM);
        System.out.println(mathService.calc(v1, v2));

        mathService.setOperation(MathService.Operation.MUL);
        System.out.println(mathService.calc(v1, v2));

        mathService.setOperation(MathService.Operation.DEV);
        System.out.println(mathService.calc(v1, v2));
    }
}
