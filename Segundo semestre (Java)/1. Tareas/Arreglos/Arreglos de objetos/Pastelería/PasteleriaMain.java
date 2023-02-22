import java.io.*;

class Pasteles {
    String cod;
    String descri;
    double precio;
    int cant;
    int cantvendidos;
    
  
    public void asignarCod(String cod){
        this.cod=cod;
    }
    public void asignarDescri(String descri){
        this.descri=descri;
    }
    public void asignarPrecio(double precio){
        this.precio=precio; 
    }
    public void asignarCant(int cant){
    this.cant=cant;
    } 
    public void asignarCantV(int cantvendidos){
        this.cantvendidos=cantvendidos;
    }
    
    public String traerCod(){
        return cod;
    }
    public String traerDescri(){
        return descri;
    }
    public double traerPrecio(){
        return precio;
    }
    public int traerCant(){
        return cant;
    }
    public int traerCantV(){
        return cantvendidos;
    }
}

class Inventario{

    public double calcularP(int x, int cantV, double precio){

        double costo=0.0;
        costo= cantV*precio;
        return costo;
    }
    public int restar(int i,int cant, int vendidos ){ 
       
        if(cant>vendidos){
        cant = cant-vendidos;}

        return cant;
        }
    public double SumarTotal(double precio, double tot){

        tot=tot+precio;

     return tot;
    }
}


public class PasteleriaMain {
    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Inventario obj= new Inventario();  
        Pasteles arreglo[] = new Pasteles[5];  
            
    String cod=null;
    int cant = 0, i=0, vendidos=0;
    double precio=0.0;
    boolean leido=true;
    double total=0.0;

    System.out.println("\n\n    Los pasteles en inventario son:        ");
    System.out.println("1. Pastel de Chocolate\n2. Pastel de Fresa\n"+
    "3. Chase cake\n4. Pastel Selva Negra \n5. Pastel Naked zanahoria ");

    for(i=0; i<arreglo.length; i++){
        arreglo[i]=new Pasteles();
        do {
            try {
                
                System.out.println("\nIngrese el código del pastel número " + (i+1) );
                cod = br.readLine();
                arreglo[i].asignarCod(cod);
                leido = true;
                while(cant<0){
                    System.out.println("No se aceptan números negativos, ingrese nuevamente");
                    leido= false;
                    }
                
            } catch (IOException e) {
                System.out.println("ERROR"+e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR"+er);
            }catch (ArrayIndexOutOfBoundsException err){
                 System.out.println("ERROR" +err);
                leido = false;
            }
            
        } while (!leido);
    }

    for(i=0; i<arreglo.length; i++){

        do {
            try {
                
                System.out.println("\nIngrese la cantidad en existencia del pastel con codigo " + arreglo[i].traerCod());
                cant= Integer.parseInt(br.readLine());
                arreglo[i].asignarCant(cant);
                leido = true;
                while(cant<0){
                    System.out.println("No se aceptan números negativos, ingrese nuevamente");
                    leido= false;
                    }
                
            } catch (IOException e) {
                System.out.println("ERROR"+e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR"+er);
            }catch (ArrayIndexOutOfBoundsException err){
                 System.out.println("ERROR" +err);
                leido = false;
            }
        } while (!leido);
        
    }  

    for(i=0; i<arreglo.length; i++){
        do {
            try {
                
                System.out.println("\nIngrese la cantidad vendida de pastel con codigo:"+ arreglo[i].traerCod());
                vendidos= Integer.parseInt(br.readLine());
                arreglo[i].asignarCantV(vendidos);
                leido = true;
                while(cant<0){
                    System.out.println("No se aceptan números negativos, ingrese nuevamente");
                    leido= false;
                    }
                
            } catch (IOException e) {
                System.out.println("ERROR"+e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR"+er);
            }catch (ArrayIndexOutOfBoundsException err){
                 System.out.println("ERROR" +err);
                leido = false;
            }
        } while (!leido);

    }

    for(i=0; i<arreglo.length; i++){
       
        do {
            try {
                
                System.out.println("\nIngrese el precio del pastel con código:" + arreglo[i].traerCod());
                precio= Double.parseDouble(br.readLine());
                arreglo[i].asignarPrecio(precio);
                leido = true;
                
            } catch (IOException e) {
                System.out.println("ERROR"+e);
            } catch (NumberFormatException er) {
                System.out.println("ERROR"+er);
            }catch (ArrayIndexOutOfBoundsException err){
                 System.out.println("ERROR" +err);
                leido = false;
            }
        } while (!leido);  
    }
    //---------------------------------------------------------------------------------------------------------------------------------
    System.out.println(" ");
    System.out.println(" ");
    System.out.println("              PASTELERIA MARIA & JOHN - INVENTARIO ACTUALIZADO DEL DIA");
    System.out.println(" ");
    //----------------------------------------------------------------------------------------------------------------------------------
    System.out.println("        TOTAL VENDIDO POR PASTEL" );
    for(i=0; i<arreglo.length; i++){

    arreglo[i].asignarPrecio(obj.calcularP(i, arreglo[i].traerCantV(), arreglo[i].traerPrecio()));

    System.out.println(" Pastel Código: "+ arreglo[i].traerCod() +" = "+arreglo[i].traerPrecio()); 
    System.out.println(" ");
    }
//----------------------------------------------------------------------------------------------------------------------------------------
    System.out.println("      CANTIDADES RESTANTES POR PASTEL" );
    for(i=0; i<arreglo.length; i++){   

    arreglo[i].asignarCant(obj.restar(i,arreglo[i].traerCant(), arreglo[i].traerCantV()));

    System.out.println("Pastel Código: "+ arreglo[i].traerCod() + " = " + arreglo[i].traerCant());
    System.out.println(" ");
    }
//---------------------------------------------------------------------------------------------------------------------------------------
for(i=0 ;i<arreglo.length;i++){
    total = obj.SumarTotal(arreglo[i].traerPrecio(), total);}
    System.out.println(" ");
    System.out.println("EL TOTAL RECAUDADO DE LA VENTA DEL DÍA =  " + total); 
    System.out.println(" ");
    }
}