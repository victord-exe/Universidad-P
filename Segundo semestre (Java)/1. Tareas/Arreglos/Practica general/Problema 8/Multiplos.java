/*Diseñe un programa que lea dos vectores a y b de 20 elementos cada uno y
multiplique el primer elemento de a con el último elemento de b y luego el
segundo elemento de a por el diecinueveavo elemento de b y así sucesivamente
hasta llegar al veinteavo elemento de a por el primer elemento de b. El resultado
de la multiplicación almacenarlo en un vector c */
public class Multiplos{
    private double a[];
    private double b[];
    
    public double[] getA() {
        return a;
    }
    public void setA(double[] a) {
        this.a = a;
    }
    public double[] getB() {
        return b;
    }
    public void setB(double[] b) {
        this.b = b;
    }

    public double[] Calcular(double[] c){
        int i;
        for (i=0; i < a.length; i++){
            c[i] = a[i] * (b[b.length-1-i]);
        }
        return c;
    }
    
}