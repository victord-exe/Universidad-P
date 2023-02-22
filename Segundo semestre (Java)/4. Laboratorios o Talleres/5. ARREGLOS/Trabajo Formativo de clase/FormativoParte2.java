import java.io.*;

class Formativo{
    public static void main(String[] args) {
        
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        boolean leido = true;
        int i, x, f, mediaplus=0;
        double media=0;

        Promedio obj = new Promedio();
        double nota[] = new double[5];

        String nomb = "", cedulae = "";

        Estudiante notaFinal[] = new Estudiante[2];
        
        for(f=0;f<notaFinal.length;f++){
            notaFinal[f] = new Estudiante(); //1 OBJETO PARA CADA POSICION 1-20
                //notaFinal[0-19].ced -> ced en la posicion 0
                //notaFinal[0-19].notaF -> ced en la posicion 0
        }

        for(x=0;x<notaFinal.length;x++){
            do{
                try {
                    leido = true;
                    System.out.println("\nIngrese el nombre del estudiante " + (x+1));
                    nomb = leer.readLine();
                } catch (NumberFormatException e) {
                        System.out.println(e);
                } catch (IOException er){
                        System.out.println(er);
                }
            } while(!leido);
            do{
                try {
                    leido = true;
                    System.out.println("Ingrese la cedula del estudiante " + (x+1));
                    cedulae = leer.readLine();
                } catch (NumberFormatException e) {
                        System.out.println(e);
                } catch (IOException er){
                        System.out.println(er);
                }
            } while(!leido);

            for(i=0;i<5;i++){
                do{
                    try {
                        leido = true;
                        System.out.println("Ingrese la nota " + (i+1) + " del estudiante " );
                        nota[i] = Double.parseDouble(leer.readLine());
                        if(nota[i]<0){
                            System.out.println("Solo se aceptan valores mayores a 0\nIntente Denuevo");
                            leido = false;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Solo se aceptan valores numericos " + e);
                        leido = false;
                    } catch (IOException er){
                        System.out.println(er);
                    }
                } while(!leido);
            }
            obj.setNombre(nomb);
            obj.setCedula(cedulae);
            obj.setNotas(nota);
            notaFinal[x].ced = obj.getCedula();
            notaFinal[x].notaF = obj.calcularP();
            for(i=0;i<nota.length;i++){
                notaFinal[x].notas[i] = obj.getNotas()[i];
            }
            media += notaFinal[x].notaF;
        }
        media = media/notaFinal.length;

        for(x=0;x<notaFinal.length;x++){
            if (notaFinal[x].notaF>media){
                mediaplus +=1;
            }
        }

        for(i=0;i<notaFinal.length;i++){
            System.out.println("\nCedula del estudiante: " + notaFinal[i].ced);
            System.out.println("Promedio del estudiante: " + notaFinal[i].notaF);
            for(x=0;x<nota.length;x++){
                System.out.println("Notas del estudiante: " + notaFinal[i].notas[x]);
            }
        }

        System.out.println("Media: " + media);
        System.out.println("No. Estudiantes encima de la media: " + mediaplus);

        
    }
}
