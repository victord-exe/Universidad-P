import java.io.*;

class Salario {
private String nom;
private float tar;
private int hora;
public void asignar (float t,int h,String n){
nom=n; hora=h; tar=t; }
public float calcular(){
return tar*hora; }
String traerN() {return nom; }
float traerT() {return tar; }
int traerH() {return hora;
}
}
class Ejemplo2 {
    public static void main(String args[]) {
    String input;
    float rata = 0;
    int horas= 0;
    String nombre="";
    Salario persona = new Salario();
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    System.out.println("\n\n****** Calculo del Salario*****\n\n");
    boolean leido=true;
    char resp='s';
    while(resp =='s' || resp =='S'){
        try {
            System.out.println("\n\n NOMBRE: ");
            nombre=br.readLine();}
            catch (IOException er){ System.out.println(er); }

            do {
            try {
            System.out.println("\n\n Digite sus horas trabajadas");
            horas = Integer.parseInt(br.readLine());
            leido = true; }
            catch(NumberFormatException e) {
            System.out.println("ERROR " + e);
            leido=false; }
            catch (IOException e){
            System.out.println(e);}

            

            try {
                System.out.println("\n\nDigite su salario por hora");
                input = br.readLine();
                rata = Float.parseFloat(input);
                leido = true; }
                catch(NumberFormatException e) {
                System.out.println("ERROR: Ingrese un valor real adecuado ");
                leido=false; }
                catch (IOException e){
                System.out.println(e);}
            }while(!leido); 

            persona.asignar(rata, horas, nombre);

            System.out.println("\nEl empleado: " + persona.traerN() + " Tiene un salario de: " + persona.calcular());

        try{
        System.out.println("\nDigite 's' o 'S' para repetir el proceso");
        resp = (char) br.read(); br.skip(2);

        }catch(IOException e){
            System.out.println("ERROR " + e);
        }catch(NumberFormatException er){
            System.out.println("ERROR " + er);
        }

        }
     
    }
}