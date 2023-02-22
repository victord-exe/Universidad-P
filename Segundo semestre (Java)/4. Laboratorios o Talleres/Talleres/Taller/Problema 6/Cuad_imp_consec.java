/*6. El cuadrado de un número entero es igual a la suma de tantos números impares
consecutivos hay (desde la unidad) como unidades tiene el número. Es decir,
3^2 es igual a 1+3+5 y (-5)^2 es igual a 1+3+5+7+9.  
*/
public class Cuad_imp_consec {
    private double z;
    private int y;



    public double getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double getZ() {
        return z;
    }
    
    public double CalcularZ(int y){
        z = Math.pow(y, 2);
        return z; 
    }

    public String BuscarImpares(){
        int n;
        int suma = 0;
        String numeros = "";

        for (n=0; n<=CalcularZ(y);n++){
            if((n % 2 !=0) && (suma+1 <= CalcularZ(y))){
                suma += n;                                  // suna = suma + n
                numeros += " + " + Integer.toString(n);
                }
                
            }
        
        return numeros;
    }
    
}