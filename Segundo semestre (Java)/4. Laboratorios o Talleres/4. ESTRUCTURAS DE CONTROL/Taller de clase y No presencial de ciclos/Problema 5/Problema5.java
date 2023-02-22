public class Problema5 {

    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int calcularProducto(int x, int prod, int a, int b) {
        for (x = 0; x < a; x++) {
            prod = prod + b;
        }
        return prod;
    }
}
