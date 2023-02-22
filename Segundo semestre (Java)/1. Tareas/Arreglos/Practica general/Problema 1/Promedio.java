public class Promedio{
    private double arrp[];

    public double[] getAr() {
        return arrp;
    }

    public void setAr(double[] ar) {
      this.arrp = ar;
    }

    
    public double calcularP(double prom){
        int i;
        for (i = 0; i<arrp.length; i++){
            prom += arrp[i];
        }
        prom = prom/arrp.length;
        return prom;
    }
    
    public int ObtenerNMayores(int mayores, double prom){
        int i;
        for (i =  0; i<arrp.length; i++){
            if (arrp[i]>prom){
                mayores +=1;
            } 
        }

        return mayores;
    }


    public double[] ObtenerLista(double[] arrmay, double prom, int i){
        for (i =  0; i<arrp.length; i++)
            if (arrp[i]>prom){
                arrmay[i] = arrp[i];
            } 
        
        return arrmay;
    } 
}