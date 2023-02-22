import java.io.*;

public class Lab4 {

    public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Libreria obj = new Libreria();

    String nom="";
    int tipo=0, cant=0;
    double costo=0.0, total=0.0;
    boolean leido= true;

    do{
        try{ System.out.println("Ingrese su nombre: ");
            nom = br.readLine();
            leido=true;
        }catch (IOException e){
            System.out.println("ERROR: " + e);
        }catch(NumberFormatException er){
            System.out.println("ERROR: " + er);
            leido=false;
        }
    }while(!leido);

    do{ 
        try{
            System.out.println("\nTIPO DE CLIENTE");
            System.out.println("1 - 2 - 3");
            tipo=Integer.parseInt(br.readLine());
            leido=true;
            if (tipo <1 || tipo>3) {
                System.out.println("El tipo de cliente no es válido\n");
                leido = false;
            }
        }catch (IOException e){
            System.out.println("ERROR: " + e);
        }catch(NumberFormatException er){
            System.out.println("ERROR: " + er);
            leido=false;
        }
    }while(!leido);

    do{ 
        try{System.out.println("Ingrese la cantidad de libros que desea comprar: ");
        cant=Integer.parseInt(br.readLine());
        leido=true;
        }catch (IOException e){
            System.out.println("ERROR: " + e);
        }catch(NumberFormatException er){
            System.out.println("ERROR: " + er);
            leido=false;
        }
    }while(!leido);

    do{ try{System.out.println("costo del libro: ");
    costo=Double.parseDouble(br.readLine());
    leido=true;
    }catch (IOException e){
        System.out.println("ERROR: " + e);
    }catch(NumberFormatException er){
        System.out.println("ERROR: " + er);
        leido=false;
    }
    }while(!leido);

    obj.setCant(cant);
    obj.setCosto(costo);
    obj.setNom(nom);
    obj.setTipo(tipo);
    obj.setTotal(total);

    System.out.println("\nCliente: " + nom);
    System.out.println("Sub total: " + obj.calculartot(cant, costo));
    System.out.println("Descuento: " + obj.calcular(obj.calculartot(cant, costo)));
    System.out.println("Neto a pagar: " +  obj.getTotal());
    }
}
