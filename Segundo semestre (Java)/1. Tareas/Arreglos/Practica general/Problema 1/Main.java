import java.io.*;;
public class Main {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0, mayores = 0;

        double prom = 0;
    
        boolean leido = true;

        double[] arr = new double [3];
        double[] arrmay = new double [arr.length];
        Promedio obj = new Promedio();


        for(i = 0; i<arr.length; i++ ){
            do{
                try{
                    System.out.println("Introduzca un valor ->");
                    arr[i] = Integer.parseInt(br.readLine());
                    leido =true;
                }catch(IOException e){
                    System.out.println("ERROR: " + e);
                }catch(NumberFormatException er){
                    System.out.println("ERROR: " + er);
                    leido = false;
                }
    
            }while (!leido);
        }

        obj.setAr(arr);
    
        prom = obj.calcularP(prom);
        mayores = obj.ObtenerNMayores(mayores, prom);
        arrmay = obj.ObtenerLista(arrmay, prom, i);

        System.out.println("Promedio: " + prom);
        System.out.println("\nNumero de valores mayores al promedio: " + mayores);
        System.out.println("\nLista de valores mayores al promedio");
        for (i = 0; i<arrmay.length; i++){
            if (arrmay[i]>0)
                System.out.println("Numero mayor al promedio: " + arrmay[i]);
        }

    }
}
