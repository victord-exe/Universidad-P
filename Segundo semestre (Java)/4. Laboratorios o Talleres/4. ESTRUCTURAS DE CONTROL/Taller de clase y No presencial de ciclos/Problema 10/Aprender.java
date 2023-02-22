import java.io.*;
import java.util.Random;

public class Aprender
{
  public static void main(String[] args)
  {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     Random random = new Random();
     Ordenletras obj = new Ordenletras();

    boolean seguir = true;
    String s;
    char resp;

     do
     {
     String abecedario = "abcdefghijklmnopqrstuvwxyz";
     int posicion_caracter1 = random.nextInt(abecedario.length());
     int posicion_caracter2 = random.nextInt(abecedario.length());

     char caracter1 = abecedario.charAt(posicion_caracter1);
     char caracter2 = abecedario.charAt(posicion_caracter2);

     obj.setValores(caracter1,caracter2);
     
     boolean ordenl = obj.orden();
  
        System.out.println("\nJUGUEMOS A APRENDER EL ABECEDARIO\n");
        System.out.println("¿Las dos letras están en orden alfabético?\n");
        System.out.print(caracter1);
        System.out.println(caracter2);
        System.out.println("\nPresiona S para SI y N para NO");

        try
        {

        String respuesta=br.readLine();

        switch(respuesta)
        {
          case "S": 
          if (ordenl == true)
          {
            System.out.println("\nFELICIDADES, LO HICISTE BIEN"); 
          }else if (ordenl == false){
            System.out.println("\nFALLASTE, LO HARÁS BIEN LA PRÓXIMA VEZ"); 
          }
          break; 
          case "s": 
          if (ordenl == true)
          {
            System.out.println("\nFELICIDADES, LO HICISTE BIEN"); 
          }else if (ordenl == false){
            System.out.println("\nFALLASTE, LO HARÁS BIEN LA PRÓXIMA VEZ"); 
          }
          break; 
          case "N":
          if (ordenl == false)
          {
            System.out.println("\nFELICIDADES, LO HICISTE BIEN");
          }else if (ordenl == true){
            System.out.println("\nFALLASTE, LO HARÁS BIEN LA PRÓXIMA VEZ"); 
          }
          break; 
          case "n":
          if (ordenl == false)
          {
            System.out.println("\nFELICIDADES, LO HICISTE BIEN");
          }else if (ordenl == true){
            System.out.println("\nFALLASTE, LO HARÁS BIEN LA PRÓXIMA VEZ"); 
          }
          break; 
      }
      System.out.println("¿Te gustaría intentarlo de nuevo?\n");
      System.out.println("\nPresiona S para SI y Cualquier otra letra para salir");

    
      s=br.readLine();
      resp = s.charAt(0);

      if (resp=='S'|| resp== 's'  )
      {
        seguir = true;
      }else

      {
        System.exit(0);
      }

       }catch (IOException io){
        System.out.println("error:"+io);
       }
    }while (seguir);
 }
}
  

     
    

