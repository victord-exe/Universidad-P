import java.io.*;

class Calificacion {
    private String nom;
    private double notas[];

    Calificacion() {
        notas = new double[5];
    }

    public void asignar(String n, double califa[]) {
        nom = n;
        notas = califa;
    }

    public void cargar(double notasF[], String nomA[], int f) {
        int j;
        nomA[f] = nom;
        for (j = 0; j < notas.length; j++)
            notasF[f] = notasF[f] + notas[j];
    }

    public void calcularN(double notasF[]) {
        int f;
        for (f = 0; f < notasF.length; f++)
            notasF[f] = notasF[f] / notas.length;
    }

    public int determinarM(double notasF[]) {
        int f;
        double may = notasF[0];
        int pos = 0;
        for (f = 1; f < notasF.length; f++)
            if (may <= notasF[f]) {
                may = notasF[f];
                pos = f;
            }
        return pos;
    }

    double[] traerNo() {
        return notas;
    }

    String traerN() {
        return nom;
    }
}

public class LabC {
public static void main(String[] args) {
BufferedReader br = new BufferedReader (new InputStreamReader
(System.in));
Calificacion obj = new Calificacion();
double nota[]= new double [5];
String nom="";
boolean leido= true;
int num=0,f,j,pos=0;
do {
try {
System.out.println ("Cuantos estudiantes son");
num=Integer.parseInt(br.readLine());
if(num<=0){
System.out.println ("El tamano del arreglo no puede ser negativo");
leido=false; } }
catch (NumberFormatException e){
    leido=false;
    System.out.println(e); }
    catch (IOException e){
    leido=false;
    System.out.println(e);}
    }while(!leido);
    
    double notasF[] = new double [num];
    String nomE[] = new String [num];
    for (j=0;j<notasF.length;j++){
    try { System.out.println ("Nombre del estudiante"); nom =br.readLine(); }
    catch (IOException e){
    System.out.println(e); }
    for(f=0;f<nota.length;f++)
    do {
    try { System.out.println ("lea la calificacion ");
    nota[f]=Double.parseDouble(br.readLine());
    if (nota[f]<=0){
    System.out.println ("Ninguna nota puede ser negativa");
    leido=false; }
    obj.asignar(nom, nota);
    
    }
    catch (NumberFormatException e){ leido=false;
    System.out.println(e);}
    catch (IOException e){ leido=false;
    System.out.println(e); }
    obj.cargar(notasF,nomE, j);
    }while(!leido);}
obj.calcularN (notasF);
for(f=0;f<notasF.length;f++)

System.out.println ("NOMBRE: "+ nomE[f]+ "pos=obj.determinarM(notasF);NOTA FINAL:"+notasF[f]);
System.out.println ("Estudiante con mayor Calificacion: "+ nomE[pos]+ " su calificacion es de "+notasF[pos]); }
}
