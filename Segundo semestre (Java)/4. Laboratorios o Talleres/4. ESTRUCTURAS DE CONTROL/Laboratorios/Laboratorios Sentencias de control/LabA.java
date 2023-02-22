import java.io.*;

class Arreglos {
private int num;
public void asignar (int n){
num=n; }
public void cargar(int i, int cod[]){
cod[i]= num; }
public int traerN(){
return num; } }
public class LabA {
public static void main(String[] args) {
BufferedReader leer = new BufferedReader (new InputStreamReader (System.in));
Arreglos obj = new Arreglos();
int cod[]=new int [5];
int f,num;
boolean leido = true;
for (f=0;f<cod.length;f++){
    do{ try { leido = true;
        System.out.println ("lea un entero");
        num= Integer.parseInt(leer.readLine());
        obj.asignar(num);
        obj.cargar (f,cod); }
        catch (IOException e) {
        System.out.println (" Error "); }
        catch (NumberFormatException e) {
        System.out.println (" Error ");
        leido = false; }
        catch (ArrayIndexOutOfBoundsException e){
        System.out.println (" Error ");
        leido = false; }
        }while (!leido); }
        System.out.println ("VECTOR CARGADO\n\n");
        for (f=0;f<cod.length;f++)
        System.out.println ("cod ["+(f+1)+ "] = " + cod[f]); } }