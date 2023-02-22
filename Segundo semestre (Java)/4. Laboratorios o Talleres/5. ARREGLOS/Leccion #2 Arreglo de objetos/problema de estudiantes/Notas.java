public class Notas {
    private String nombre, cedula;
    private int nota;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void cargar(int vec[], int i) {
        vec[i] = nota;
    }

    public int calcularNf(int vec[]) {
        int notaf = 0, i;
        for (i = 0; i < vec.length; i++) {
            notaf = notaf + vec[i];
        }
        notaf = notaf / vec.length;

        return notaf;
    }

    public int calcularNumf(int notaFin, int cont) {
        if (notaFin > 70) {
            cont = cont + 1;
        }
        return cont;
    }

    public int calcularSup(Estudiante aver[], int nota, int prom,int encima) {
       int enci=encima;

        if (nota > prom) {

            enci = enci + 1;
        }
        return enci;
    }

    public int calcularProm(int acum, Estudiante cant[]){
        int average = 0;
        average = acum/cant.length;

        return average;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public int getNota() {
        return nota;
    }

}
