public class Inverso {
    private double normal[];

    public double[] getNormal() {
        return normal;
    }

    public void setNormal(double[] normal) {
        this.normal = normal;
    }

    public double[] invertir(double[] inverso){
        int i;
        for (i=0; i < normal.length; i++){
            inverso[i] = normal[normal.length-1-i];
        }
        return inverso;
        
    }
}
