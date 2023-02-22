import java.io.*;
class Normalizacion {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    public void cargar(int x, int noma[]){
        noma[x] = num; 
    }

    public int calcularM(int noma[]){
        int may = noma [0];
        int f;
        for (f = 1; f<noma.length; f++){
            if (noma[f] > may){
                may = noma[f];
            }
        }
        return may;
    }

    public void calcularN(int may, int noma[]){
        int f;
        for (f = 0; f<noma.length; f++)
            noma[f] = noma[f]/may;
    }
}

public class Problema2{
    public static void main(String[] args) {
        Normalizacion obj = new Normalizacion();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int noma[] = new int[5];
        int x, num = 0, may = 0;
        boolean leido = true;

        for (x=0;x < noma.length; x++){
            do{ 
                try{
                    System.out.println("Lea un numero");
                    num = Integer.parseInt(br.readLine());
                    leido = true;

                }catch (IOException e){
                    System.out.println("ERROR: " + e);
                }catch (NumberFormatException er){
                    System.out.println("ERROR:" + er);
                }
            }while (!leido);
        obj.setNum(num);
        obj.cargar(x, noma);
        } //llave del for

        may = obj.calcularM(noma);
        System.out.println("Arreglo antes de normalizar");

        for(x = 0; x < noma.length; x++){
            System.out.println("Noma [" + (x+1) + "] = " + noma[x]);
        }

        obj.calcularN(may, noma);


        System.out.println("\nArreglo despues de normalizar");
        for(x = 0; x < noma.length; x++){
            System.out.println("Noma [" + (x+1) + "] = " + noma[x]);
        }
    }
}