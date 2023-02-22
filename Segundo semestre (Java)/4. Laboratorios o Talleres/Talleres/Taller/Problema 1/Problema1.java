import java.io.*;
public class Problema1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Valor obj = new Valor();

        int i;
        double x=0;
        double y=0;
        boolean leido = true;

       
            for (i = 0; i<10; i++){

                do{

                    try{
                    
                        System.out.println("Ingrese el valor de la base");
                        y = Double.parseDouble(br.readLine());
                        leido = true;
                       
                    }catch (IOException e){
                        System.out.println("ERROR: " + e);
                    }catch(NumberFormatException er){
                        System.out.println("ERROR: " + er);
                        leido = false;
                    }

                }while (!leido);

                do{

                    try{
                                           
                        System.out.println("Ingrese el valor del exponente");
                        x = Double.parseDouble(br.readLine());
                        leido = true;
                        
                    }catch (IOException e){
                        System.out.println("ERROR: " + e);
                    }catch(NumberFormatException er){
                        System.out.println("ERROR: " + er);
                        leido = false;
                    }

                }while (!leido);

                obj.setY(y);
                obj.setX(x);
                System.out.println("Resultado: " + obj.CalcularZ(y));

            }
    }
}
