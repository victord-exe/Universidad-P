/**
 * @(#)Ejemplo.java
 *
 *
 * @author 
 * @version 1.00 2021/11/16
 */

public class Ejemplo {
        
    
    public static void main(String[] args) {
         String idiomas[] = {"Ingles", "Aleman", "PORTUGUES","MANDARIN"};
         int habita []= new int [5];
         char alfa[] = new char[26];
         int f;
         double boni[] = new double [100];
         habita[2]=6;
         habita[1]=34;
         System.out.println ("Tamano fisico de Idiomas:"+idiomas.length);
         System.out.println ("Tamano fisico de boni:"+boni.length);
         for (f=0;f<idiomas.length;f++)
         	System.out.print ("  "+ idiomas[f]+ "  ");
         for (f=0;f<habita.length;f++)
         	System.out.println ("\n"+habita[f]);
         
    }
}
