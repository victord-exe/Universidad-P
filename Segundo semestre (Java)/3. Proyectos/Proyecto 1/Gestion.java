public class Gestion{
    private int cafe;
    private int n_cajasG = 0, n_cajasM = 0, n_cajasP = 0;
    private int ptcm, ptcg;
    private double ptcp;
    
    public int getCafe() {
        return cafe;
    }

    public void setCafe(int cafe) {
        this.cafe = cafe;
    }
    public int getN_cajasG() {
        return n_cajasG;
    }

    public void setN_cajasG(int n_cajasG) {
        this.n_cajasG = n_cajasG;
    }

    public int getN_cajasM() {
        return n_cajasM;
    }

    public void setN_cajasM(int n_cajasM) {
        this.n_cajasM = n_cajasM;
    }

    public int getN_cajasP() {
        return n_cajasP;
    }

    public void setN_cajasP(int n_cajasP) {
        this.n_cajasP = n_cajasP;
    }
        public double getPtcp() {
        return ptcp;
    }

    public void setPtcp(int ptcp) {
        this.ptcp = ptcp;
    }

    public int getPtcm() {
        return ptcm;
    }

    public void setPtcm(int ptcm) {
        this.ptcm = ptcm;
    }

    public int getPtcg() {
        return ptcg;
    }

    public void setPtcg(int ptcg) {
        this.ptcg = ptcg;
    }


    /*
     * Calcular el valor total a pagar por bolsas para el café arabico y el robusto
    */
    public double CalcularTotal(String nombre){ //agregar un if en el main para poder usar el calcular que se necesite
        double total = 0;
        if (nombre == "Arabica"){
            total = cafe * 5.50;
        } else if (nombre == "Robusta"){
            total = cafe * 10;
        }
        return total;
    }

    /*
     * Contadores para saber la cantidad de cajas que se van a utilizar.
    */
    /* ESTO DA ERROR, NO SUMA BIEN AL LLAMAR AL HP METODO, CUENTA DE NUEVO */
    public int SumarCajaG(){
        this.n_cajasG  = n_cajasG+ 1;        
        return n_cajasG;
    }
    public int SumarCajaM(){
        this.n_cajasM += 1;
        return n_cajasM;
    }
    public int SumarCajaP(){
        this.n_cajasP += 1;
        return n_cajasP;
    }

    /*
     * Calcular el valor total a pagar por cajas.
    */
    public double Calcular_PTCG(){ 
        ptcg = n_cajasG * 2;    //ptcg = precio total de cajas grandes
        return ptcg;
    }
    public double Calcular_PTCM(){ 
        ptcm = n_cajasM * 1;    //ptcg = precio total de cajas mediana
        return ptcm;
    }
    public double Calcular_PTCP(){ 
        ptcp = n_cajasM * 0.50;    //ptcg = precio total de cajas pequeñas
        return ptcp;
    }

    /*
     * Calcular el total por pagar
    */
    public double CalcularPago(String nombre){
        double totalPago = 0;
        
        totalPago = Calcular_PTCP() +
                    Calcular_PTCM() +
                    Calcular_PTCG() +
                    CalcularTotal(nombre);

        return totalPago;
    }

    /*
     * Ciclo que controla el programa.
    */
    public void CalcularCajas(){
        int restante = cafe;

        while (restante>10){
            if (restante >=20){
                restante -= 20;
                
            }
            else{
                restante = 0;    
            }
            SumarCajaG();
        }
        while ((restante > 5) && (restante<=10)){
            restante = 0;
            SumarCajaM();
        }
        while ((restante > 0) && (restante<=5)) {
            restante = 0;
            SumarCajaP();
        }
    }
}