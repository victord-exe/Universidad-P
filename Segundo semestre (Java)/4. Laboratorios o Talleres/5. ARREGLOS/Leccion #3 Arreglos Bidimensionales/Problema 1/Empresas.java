public class Empresas {
    private double ventasM;

    public double getVentasM() {
        return ventasM;
    }

    public void setVentasM(double ventasM) {
        this.ventasM = ventasM;
    }

    public void Sumar(double[][] ventas, int i, int j) {
        ventas[i][j] += ventasM;
    }

    public double[] calcularPromedios(double[] media) {
        int j;
        for (j = 0; j < media.length; j++) {
            media[j] /= 6;
        }
        return media;
    }

    public double calcularMedia(double[] promedios, double media) {
        int i;
        for (i = 0; i < promedios.length; i++) {
            media += promedios[i];
        }
        media /= promedios.length;
        return media;
    }

    public boolean VentasSuperiores(double[] promedios, double media, int i){
        if (promedios[i]>media){
            return true;
        }else{
            return false;
        }
    }

    public double calcularMayor(double[] promedios,double mayor){
        int i;
        for (i = 0; i<promedios.length; i++){
            if (promedios[i]>mayor){
                mayor = promedios[i];
            }
        }
        return mayor;
    }


}