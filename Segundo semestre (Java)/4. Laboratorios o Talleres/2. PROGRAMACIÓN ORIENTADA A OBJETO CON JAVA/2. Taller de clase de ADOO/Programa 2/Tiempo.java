public class Tiempo {
    private int segundos;

    public void asignarS(int a) {
        segundos = a;
    }

    public int getSegundos() {
        return segundos;
    }

    public float calcularM() {
        return segundos / 60;
    }

    public float calcularH() {
        return segundos / 3600;
    }

    public int traerS() {
        return segundos;
    }
}
