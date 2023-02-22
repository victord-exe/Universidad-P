public class Pagos {
    private int cantm, cantl, tipo;

    void asignar(int t, int c, int l) {
        cantm = c;
        cantl = l;
        tipo = t;
    }

    double calcularP() {
        double costop;
        if (tipo == 1)
            costop = cantm * 30 + cantl * 7.00;
        else
            costop = cantm * 50 + cantl * 7.00;
        return costop;
    }

    String determinar() {
        String resp;
        if (tipo == 1)
            resp = "VETERANO";
        else
            resp = "REGULAR";
        return resp;
    }
}
