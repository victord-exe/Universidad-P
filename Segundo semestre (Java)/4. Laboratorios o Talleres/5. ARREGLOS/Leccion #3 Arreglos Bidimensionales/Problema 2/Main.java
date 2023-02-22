import java.io.*;

public class Main {
    public static void main(String[] args) {

        Herramienta obj = new Herramienta();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double notas[][], promedios[], nota = 0;
        String nombre = "", nombres[];
        int i, j;
        boolean leido = true;

        notas = new double[5][4];
        promedios = new double[notas.length];
        nombres = new String[notas.length];

        for (i = 0; i < notas.length; i++) {
            do {
                try {
                    System.out.println("\n***Estudiante No." + (i + 1) + "***");
                    System.out.println("Ingrese su nombre: ");
                    nombre = br.readLine();
                    leido = true;
                    obj.setNombre(nombre);
                    obj.cargarNombres(nombres, i);
                } catch (IOException e) {
                    System.out.println("ERROR: " + e);

                } catch (ArrayIndexOutOfBoundsException err) {
                    System.out.println("ERROR: " + err);
                    leido = false;
                }

            } while (!leido);

            for (j = 0; j < notas[0].length; j++) {
                do {
                    try {
                        System.out.println("Ingrese la nota No. " + (j + 1) + ": ");
                        nota = Double.parseDouble(br.readLine());
                        leido = true;
                        obj.setNota(nota);
                        obj.cargar(notas, i, j);
                    } catch (IOException e) {
                        System.out.println("ERROR: " + e);
                    } catch (NumberFormatException er) {
                        System.out.println("ERROR: " + er);
                        leido = false;
                    } catch (ArrayIndexOutOfBoundsException err) {
                        System.out.println("ERROR: " + err);
                        leido = false;
                    }
                } while (!leido);

            }
        }

        notas = obj.ordenar(notas);
        notas = obj.eliminarNotasBajas(notas);
        promedios = obj.promediar(notas, promedios);

        System.out.println("\n\n*********ESTUDIANTES*******");

        for (i = 0; i < notas.length; i++) {
            System.out.println("\nNOTAS del estudiante " + nombres[i]);
            for (j = 0; j < notas[0].length; j++) {
                System.out.println("Nota " + (j + 1) + ": " + notas[i][j]);
            }
            System.out.println("Promedio final luego de eliminar las dos notas mas bajas: " + promedios[i]);
        }

    }
}
