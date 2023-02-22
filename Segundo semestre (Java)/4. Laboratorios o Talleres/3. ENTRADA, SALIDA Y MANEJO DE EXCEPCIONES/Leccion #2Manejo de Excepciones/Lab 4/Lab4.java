import java.io.*;

public class Lab4 {

    public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Libreria obj = new Libreria();

    String nom=null;
    int tipo=0, cant=0;
    double costo=0.0, total=0.0;
    boolean leido= true;

    do{
        try{ System.out.println("Ingrese su nombre: ");
            nom = br.readLine();
            leido=true;
        }catch (IOException e){
            System.out.println("ERROR");
        }catch(NumberFormatException er){
            System.out.println("ERROR");
            leido=false;
        }
    }while(!leido);

    do{ 
        try{System.out.println("Ingrese el tipo de cliente: tipo 1, tipo 2, tipo 3 ");
            tipo=Integer.parseInt(br.readLine());
            leido=true;
            if (tipo > 3) {
                System.out.println("El tipo de cliente no es válido");
                leido = true;
            }
        }catch(IOException e){
            System.out.println("ERROR");
        }catch(NumberFormatException er){
            System.out.println("ERROR");
            leido= false;
        }
    }while(!leido);

    do{ 
        try{System.out.println("Ingrese la cantidad de libros a comprar: ");
        cant=Integer.parseInt(br.readLine());
        leido=true;
        }catch(IOException e){
            System.out.println("ERROR");
        }catch(NumberFormatException er){
            System.out.println("ERROR");
            leido=false;
        }
    }while(!leido);

    do{ try{System.out.println("Ingrese el costo por libro: ");
    costo=Double.parseDouble(br.readLine());
    leido=true;
    }catch(IOException e){
        System.out.println("ERROR");
    }catch(NumberFormatException er){
        System.out.println("ERROR");
        leido=false;
    }
    }while(!leido);

    obj.asignar(tipo, cant, nom, costo,total);
    System.out.println(" " );
    System.out.println("NOMBRE DEL CLIENTE: " + nom);
    System.out.println("Total a pagar: " + obj.calculartot(cant, costo));
    System.out.println("Descuento: " + obj.calcular(obj.calculartot(cant, costo)));
    System.out.println("Neto a pagar: " +  obj.traerTotal());
    }
}
