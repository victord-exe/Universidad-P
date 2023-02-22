/**
 * @(#)Ejemplo.java
 *
 *
 * @author 
 * @version 1.00 2021/11/16
 */
/*Elabore un programa que tiene para 5 provincias  con alta incidencia de covid se les solicita determinar el total de infectados y cual es la provincia con mayor cantidad casoscon mayor casos
 *para ello usted debe leer la cantidad total de infectados por provincia.*/
import java.io.*;
class Covid {
	
private int infe;

public void asignar (int i){
	infe=i;
}	
public void cargar (int totI[], int f){
	totI[f]=infe;
}	
public int totalizar(int totI[]){
   int f, tot=0;
   for (f=0;f<totI.length;f++)
      tot= tot+totI[f];
      return tot;  	
}
public int mayor (int habita[]){
   int f;
   int may =habita[0];
   int pos =0;
   for(f=1;f<habita.length;f++)
   	if (habita[f] > may){
   	  may= habita[f];
   	  pos = f;
   	}	
   return pos;	
	
	
	
}	
    int traer (){
    	return infe;
    }			
}

public class EjemploA {
        
    
    public static void main(String[] args) {
          BufferedReader br =new BufferedReader (new InputStreamReader (System.in));
          Covid obj = new Covid();         
         int habita []= new int [5];
         int f,pos;
         int infe;
         boolean leido=true;
         
      for (f=0;f<habita.length;f++)
         do {
         	try {
         	      System.out.println ("Cantidad de infectados");
         	      infe=Integer.parseInt(br.readLine());
         	      while (infe<=0){
         	      System.out.println ("Cantidad de infectados no puede ser negativa vuela a leer");
         	      infe=Integer.parseInt(br.readLine());	
         	      }
         	      obj.asignar(infe);
         	      obj.cargar(habita,f);
         	      leido = true;   	}
         	catch (IOException e){
         		System.out.println ("ERROR");
         	}
         	catch (NumberFormatException e){
         		System.out.println ("ERROR"+ e);
         		leido = false;
         	}       	
         	
         }while (!leido);	
              	
      	
         System.out.println ("Total de Pacientes por provincias\n");
         for (f=0;f<habita.length;f++)
         	System.out.println ("\n"+habita[f]);
        System.out.println ("TOTAL DE INFECTADOS: "+ obj.totalizar (habita)) ;
        pos = obj.mayor(habita);
        System.out.println ("Provincia con mayor infectacion: "+(pos+1)+ "  Con : " + habita[pos]+ "Infectado") ;
    }
}
