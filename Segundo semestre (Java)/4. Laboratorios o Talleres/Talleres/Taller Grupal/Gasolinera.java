public class Gasolinera {
    private double servicio;
    private double costo;
    private char turno;

    public double getServicio() {
        return servicio;
    }
    public void setServicio(double servicio) {
        this.servicio = servicio;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public char getTurno() {
        return turno;
    }
    public void setTurno(char turno) {
        this.turno = turno;
    }
    public double calcularValorP(){
        return servicio*costo;
    }
}
