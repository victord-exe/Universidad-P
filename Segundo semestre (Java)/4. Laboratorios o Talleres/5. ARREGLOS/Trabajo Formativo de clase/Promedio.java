
public class Promedio{

    private String nombre;
    private String cedula;
    private double notas[];

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public double[] getNotas() {
        return notas;
    }
    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    Promedio() {
        notas = new double[5];
    }

    double calcularP(){
        int i;
        double prom= 0;
        for(i=0;i<notas.length;i++){
            prom += notas[i];
        }
        return prom/5;
    }
    
}
