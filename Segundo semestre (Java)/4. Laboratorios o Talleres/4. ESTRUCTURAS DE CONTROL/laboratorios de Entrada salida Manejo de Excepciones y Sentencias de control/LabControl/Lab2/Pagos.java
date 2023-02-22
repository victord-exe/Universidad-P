public class Pagos {
    private int cantm, cantl, tipo;


    public void setCantm(int cantm) {
        this.cantm = cantm;
    }

    public void setCantl(int cantl) {
        this.cantl = cantl;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    double calcularP() {
        double costop = 0;
        if (tipo == 1)
            costop = cantm * 30 + cantl * 7.00;
        else
            costop = cantm * 50 + cantl * 7.00;
        return costop;
    }

    String determinar() {
        String resp = "";
        if (tipo == 1)
            resp = "VETERANO";
        else
            resp = "REGULAR";
        return resp;
    }
}
