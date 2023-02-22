public class Sumatoria{
    private double a[];
    private double b[];

    public double[] getA() {
        return a;
    }
    public void setA(double[] a) {
        this.a = a;
    }

    public double[] getB(){
        return b;
    }
    public void setB(double[] b){
        this.b = b;
    }

    public double[] Sumar(double[] c){
        int i;
        for (i = 0; i<c.length; i++){
            c[i] = a[i] + b[i];
        }
        return c;
    }
}