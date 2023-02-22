/*6. El cuadrado de un número entero es igual a la suma de tantos números impares
consecutivos hay (desde la unidad) como unidades tiene el número. Es decir,
3^2 es igual a 1+3+5 y (-5)^2 es igual a 1+3+5+7+9.  
*/
public class Cuad_imp_consec {
    private int y;

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double CalcularZ(int y, double z) {
        z = Math.pow(y, 2);
        return z;
    }

    public String BuscarImpares(double z) {
        int n;
        int suma = 0;
        String numeros = "";

        for (n = 0; n <= CalcularZ(y, z); n++) {
            if ((n % 2 != 0) && (suma + 1 <= CalcularZ(y, z))) {
                suma += n; // suna = suma + n
                numeros += " + " + Integer.toString(n);
            }

        }

        return numeros;
    }

}