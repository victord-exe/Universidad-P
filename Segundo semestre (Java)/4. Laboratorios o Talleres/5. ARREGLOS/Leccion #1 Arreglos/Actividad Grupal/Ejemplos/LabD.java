import java.io.*;
class Arreglo{
private double num;
public void asignar (double a)
{ num= a; }
public void cargar (double va[], int i){
va[i] =num;}
public double calcular (double []va){
int f;
double tot=0;
for( f=0;f<va.length; f++)
tot = va[f]+ tot;
return tot;}
double traerN() {
return num;}}


public class LabD {
    public static void main(String[] args) { Arreglo obj = new Arreglo();
    double tot[]= new double [4];
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); int i;
    double n;
    boolean leido= true;
    char resp ='s';
    while (resp =='s'){
    try {
    leido = true;
    for (i=0; i<tot.length;i++) {
    do {
    try {
        leido = true;
System.out.println("INTRODUZCA LAS CALIFICACIONE FINALES EN NUMERO REAL ");
n =Double.parseDouble(br.readLine());
if (n<0.00){
System.out.println("LAS CALIFICACIONE NO PUEDEN SER NEGATIVAS, VUELVA A LEER");
leido =false;
}
obj.asignar (n);
obj.cargar (tot, i); }
catch (NumberFormatException er){
leido = false; System.out.println (er); }
catch (IOException er){ leido = false; System.out.println (er); }
catch (ArrayIndexOutOfBoundsException er){ leido = false;
System.out.println("VALOR FUERA DE RANGO"); }
} while(!leido); }
System.out.print (" NOTA DEL ESTUDIANTES ");
for( i=0;i<tot.length; i++)
System.out.print ( " "+tot[i]+ " ");
System.out.println ( "NOTA FINAL: "+ obj.calcular(tot)/tot.length);
System.out.println ("DESEA PROCESAR OTRO ESTUDIANTE s/n");
resp = (char) br.read(); br.skip(1); }
catch (IOException e){
leido = false;
System.out.println("ERROR" + e);
}while(!leido); }
System.out.print (" NOTA DEL ESTUDIANTES ");
for( i=0;i<tot.length; i++)
System.out.print ( " "+tot[i]+ " ");
System.out.println ( "NOTA FINAL: "+ obj.calcular(tot)/tot.length);
do{
try{
System.out.println ("DESEA PROCESAR OTRO ESTUDIANTE s/n");
resp = (char) br.read(); br.skip(1); }
catch (IOException e){
leido = false;
System.out.println("ERROR" + e);}
}while(!leido);

} } 