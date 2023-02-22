public class Estudiante {
    
    String ced;
    double notaF;
    double notas[];

    public String getCed() {
        return ced;
    }
    public void setCed(String ced) {
        this.ced = ced;
    }

    public double getNotaF() {
        return notaF;
    }
    public void setNotaF(double notaF) {
        this.notaF = notaF;
    }

    public double[] getNotas() {
        return notas;
    }
    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    Estudiante(){
        notas = new double[5];
    }
}
