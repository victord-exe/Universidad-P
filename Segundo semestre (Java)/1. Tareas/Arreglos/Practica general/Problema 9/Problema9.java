import java.io.*;

public class Problema9 {
    public static void main(String[] args) {
        boolean leido = true;

        int i, j;
        double cum = 0, total = 0;
        double ht[] = new double[5];
        General worker[] = new General[5];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Media obj = new Media();

        for (i = 0; i < worker.length; i++) {
            worker[i] = new General();
            // Nombre del trabajador
            do {
                try {
                    System.out.println("Ingrese el nombre del trabajador");
                    worker[i].name = br.readLine();
                    leido = true;
                } catch (IOException e) {
                    System.out.println("ERROR " + e);
                } catch (IndexOutOfBoundsException er) {
                    System.out.println("ERROR " + er);
                }
            } while (!leido);

            // Numero de horas trabajadas en la semana. Aqui se trabaja un array
            for (j = 0; j < ht.length; j++) {
                do {
                    try {
                        System.out.println("Numero de horas trabajadas para el día " + (j + 1) + ": ");
                        ht[j] = Double.parseDouble(br.readLine());
                        leido = true;
                    } catch (IOException e) {
                        System.out.println("ERROR " + e);
                    } catch (IndexOutOfBoundsException er) {
                        System.out.println("ERROR " + er);
                    } catch (NumberFormatException err) {
                        System.out.println("ERROR: " + err);
                        leido = false;
                    }
                } while (!leido);
            }

            obj.setHT(ht);

            cum = (obj.promediar(cum));
            worker[i].setH(cum);
            cum = 0;
        }

        for (i = 0; i < worker.length; i++) {
            total = obj.Acumular(worker, worker[i].getH(), total);
        }
        total = obj.Promediartot(total, worker);
        System.out.println("");
        System.out.println("Promedio de horas trabajadas: ");
        System.out.println("\nNombre:            Media del docente:");

        for (i = 0; i < worker.length; i++) {
            System.out.println(worker[i].getN() + "                    " + worker[i].getH());
        }

        System.out.println("Promedio de horas trabajadas de los empleados: " + total);
    }
}
