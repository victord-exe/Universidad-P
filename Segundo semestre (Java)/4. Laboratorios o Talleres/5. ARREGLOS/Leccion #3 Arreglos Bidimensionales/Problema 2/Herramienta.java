public class Herramienta {
    private double nota;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void cargar(double[][] notas, int i, int j) {
        notas[i][j] = nota;
    }

    public void cargarNombres(String[] nombres, int i) {
        nombres[i] = nombre;
    }

    public double[][] ordenar(double[][] a) {
        double temporal = 0;
        int x, i, j;
        for (x = 0; x < a.length; x++) {
            for (i = 0; i < a[0].length; i++) {
                for (j = 1; j < (a[0].length - i); j++) {
                    if (a[x][j - 1] > a[x][j]) {
                        temporal = a[x][j - 1];
                        a[x][j - 1] = a[x][j];
                        a[x][j] = temporal;
                    }
                }
            }
        }
        return a;
    }

    public double[][] eliminarNotasBajas(double[][] notas) {
        int i;
        for (i = 0; i < notas.length; i++) {
            notas[i][0] = 0;
            notas[i][1] = 0;
        }
        return notas;
    }

    public double[] promediar(double[][] notas, double[] promedio) {
        int i, j;
        for (i = 0; i < notas.length; i++) {
            for (j = 1; j < notas[0].length; j++) {
                promedio[i] += notas[i][j];
            }
            promedio[i] /= (notas[0].length - 2);
        }
        return promedio;

    }

}
