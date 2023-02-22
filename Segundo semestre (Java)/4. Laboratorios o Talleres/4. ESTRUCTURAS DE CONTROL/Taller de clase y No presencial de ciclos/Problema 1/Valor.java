/*1. Elabore un programa que lea 10 valores para x y y, calcule e imprima el valo
de Z; utilizando la fórmula : Z= Yx
*/
public class Valor{
    private double x;
    private double y;


    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    
    public double CalcularZ(double z){
            z = 1;
            double i;
            for (i = x; i != 0; i--)
                z *=y;
            return z;
    }
    
}