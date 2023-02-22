public class Edades{
    private int edad1;
    private int edad2;
    private int edad3;
    
    public void asignarA(int a){
         edad1=a; 
        }
    public void asignarB(int b){
         edad2=b; 
        }
    public void asignarC(int c){
         edad3=c; 
        }
    public double Promedio(){
        return (edad1+edad2+edad3)/3;
        }
}
