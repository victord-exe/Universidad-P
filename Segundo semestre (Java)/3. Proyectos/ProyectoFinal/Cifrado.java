public class Cifrado{
    private String dato;    //contendrá los 4 digitos
    private int datoC[];   //Contendrá el dato cifrado
    private int datoD;   //Contendrá el dato descifrado
    
    public Cifrado(){
        this.datoC = new int[4];
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public int[] getDatoC() {
        return datoC;
    }

    public void setDatoC(int[] datoC) {
        this.datoC = datoC;
    }

    public int getDatoD() {
        return datoD;
    }

    public void setDatoD(int datoD) {
        this.datoD = datoD;
    }


    public void Cifrar(){
        dato = dato.toString();
        int i;
        int result;
        int aux1, aux2;
        
        for (i=0; i<4; i++){

            result = dato.charAt(i);
            result = (result+7) % 10;
            datoC[i] = result;
        }

        aux1 = datoC[2];
        datoC[0] = datoC[2];
        datoC[2] = aux1;
        
        aux2 = datoC[1];
        datoC[1] = datoC[3];
        datoC[3] = aux2;
    }
    


}