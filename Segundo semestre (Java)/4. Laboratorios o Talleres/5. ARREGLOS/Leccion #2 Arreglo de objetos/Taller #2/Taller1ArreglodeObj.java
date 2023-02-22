import java.io.*;

class Notas {
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

class Estudiante {
    String ced;
    int nota;

    public void setN(int a){
        nota = a;
    }
    public void setC(String b){
        ced = b;
    }
    public String getC(){
        return ced;
    }
    public int getN(){
        return nota;
    }
}

public class Taller1ArreglodeObj {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Notas obj = new Notas();

        Estudiante notaFinal[] = new Estudiante[3];

        int vec[] = new int[2];
        int encima = 0, conta = 0, nota = 0, i, j,acum = 0, prom = 0;
        String nombre = "", ced = "";
        boolean band = true;

        for (i = 0; i < notaFinal.length; i++) {

            notaFinal[i] = new Estudiante();

            try {
                System.out.println("Ingrese el nombre: ");
                nombre = br.readLine();
                obj.setNombre(nombre);
            } catch (IOException e) {
                System.out.println(e);
            }

            try {
                System.out.println("Ingrese la cedula: ");
                ced = br.readLine();
                notaFinal[i].setC(ced);
            } catch (IOException e) {
                System.out.println(e);
            }

            for (j = 0; j < vec.length; j++) {
                do {
                    try {
                        band = true;
                        System.out.println("Ingrese la nota #" + (j + 1) + ": ");
                        nota = Integer.parseInt(br.readLine());
                        if (nota < 0 || nota > 100) {
                            System.out.println("Error, Ingrese nuevamente");
                            band = false;
                        }
                        obj.setNota(nota);
                        obj.cargar(vec, j);
                    } catch (IOException e) {
                        System.out.println(e);
                    } catch (NumberFormatException re) {
                        System.out.println(re);
                        band = false;
                    }
                } while (!band);
            }

            System.out.print("El estudiante de cedula " + notaFinal[i].getC() + " sus notas son: \n");
            for (j = 0; j < vec.length; j++) {
                System.out.println("NOTA " + (j + 1) +" --> " + vec[j]);
            }

            notaFinal[i].setN(obj.calcularNf(vec));

            System.out.println("\nSu nota final es de: " + notaFinal[i].getN() + "\n");

            conta = obj.calcularNumf(notaFinal[i].getN(), conta);

            acum = acum + notaFinal[i].getN();

        }

        prom = obj.calcularProm(acum, notaFinal);

        for(i=0 ; i<notaFinal.length; i++){

        encima = obj.calcularSup(notaFinal,notaFinal[i].getN(), prom,encima);
        
        }

        

        System.out.println("El numero de estudiante que aprobaron el curso es de: " + conta);
        System.out.println("La nota promedio del curso es: " + prom);
        System.out.println("Cantidad de estudiantes que pasaron el curso por encima del promedio: " + encima);


    }

}
