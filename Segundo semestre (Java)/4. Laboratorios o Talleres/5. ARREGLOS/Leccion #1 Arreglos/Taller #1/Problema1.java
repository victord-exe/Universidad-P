/* Construya un programa que al recibir como dato un arreglo unidimensional de n elementos enteros
 * y un numero entero, determine cuantas veces se encuentra este numero dentro del arreglo
 */

/* Victor Rodriguez 20-70-7414 */
 /*   ADOO     */

 /*  Numeros   */

 /*  -vaca[]   */
 /*  - num     */

 /* +asignar()
  * +buscar()
  * +traer()
  */
import java.io.*;

class Numeros {
    private int veca[]; //arreglo: atributo de la clase
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Numeros(int n) {     //Constructor: crea esapcio para el atributo
        this.veca = new int[n];
    }

    public void setVeca(int[] veca) {   //Carga el arreglo de la clase con el que viene del main
        this.veca = veca;
    }
   
    public int buscar(){
        int cuenta = 0;
        int f;
        for (f = 0; f<veca.length; f++)
            if (num == veca[f])
                cuenta ++;
        return cuenta;
    }

    public int[] traer(){
        return veca;
    }
}

public class Problema1{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean leido = true;
        int t=0, i, num=0;

        do{
            try{
                System.out.println("Digite el tamano del arreglo: ");
                t = Integer.parseInt(br.readLine());
                leido = true;
                if (t<=0){
                    System.out.println("El tamano del arreglo no puede ser cero ni negativo");
                    System.out.println("Introduzca otro numero");
                    leido = false;
                }
                
            }catch(IOException e){
                System.out.println("ERROR: " + e);
            }catch(NumberFormatException er){
                System.out.println("ERROR: " + er);
                leido = false;
            }

        }while (!leido);

        int veca[] = new int[t];
        Numeros obj = new Numeros(t);   //el obj se crea despues porque t es el tama;o del arreglo.

        for (i=0; i<veca.length;i++){
            do{
                try{
                    
                    System.out.println("Digite el numero: ");
                    veca[i]=Integer.parseInt(br.readLine()); //Cargar el arreglo
                    
                }catch(IOException e){
                    System.out.println("ERROR: " + e);
                }catch(NumberFormatException er){
                    System.out.println("ERROR: " + er);
                    leido = false;

                }
            }while (!leido);
        }

        obj.setVeca(veca);

        do{
            try{

                System.out.println("Digite el numero que desea buscar: ");
                num = Integer.parseInt(br.readLine());
                leido = true;

            }catch(IOException e){
                System.out.println("ERROR: " + e);
            }catch(NumberFormatException er){
                System.out.println("ERROR: " + er);
                leido = false;
            }   
        }while(!leido);

        veca = obj.traer();
        for (i=0;i<veca.length;i++){
            System.out.println(" veca [" + (i+1) + "] = " + veca[i]);
        }

        obj.setNum(num);
        System.out.println("En el arreglo, " + obj.getNum() + " se repite " + obj.buscar() + " veces");
    }
}