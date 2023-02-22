public class Diferente {
    private double a[];

    public double[] getA() {
        return a;
    }

    public void setA(double[] a) {
        this.a = a;
    }

    public double EncontrarM(double mayor) {
        int i;
        double aux = 0;
        for (i = 0; i < a.length; i++) {
            if (a[i] > aux) {
                aux = a[i];
            }
        }
        return mayor;
    }

}