class Media {
    private double horasT[];

    public void setHT(double ht[]) {
        horasT = ht;
    }

    public double[] getHT() {
        return horasT;
    }

    public double promediar(double acum) {
        int x;
        // double acum;
        for (x = 0; x < horasT.length; x++) {
            acum += horasT[x];
        }
        acum = acum / horasT.length;
        return acum;
    }

    public double Acumular(General array[], double horasF, double tot) {
        tot += horasF;
        return tot;
    }

    public double Promediartot(double tot, General array[]) {
        tot /= array.length;
        return tot;
    }

}