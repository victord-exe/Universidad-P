public class Funcion {
    
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


    public double calcularS(){
        double f=0.00;

        f = x/y*(x-y);

        return f;
    }

}
