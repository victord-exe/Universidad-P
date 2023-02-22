public class Temperatura {
    private double celcius[];

    public double[] getCelcius() {
        return celcius;
    }

    public void setCelcius(double[] celcius) {
        this.celcius = celcius;
    }

    public double[] Transformar(double[] f) {
        int i;
        for (i = 0; i < celcius.length; i++) {
            f[i] = (celcius[i] * 1.8) + 32;
        }
        return f;
    }

    public double ObtenerAlta(double[] f, double top) {
        double aux = f[0];
        int i;
        for (i = 0; i < celcius.length; i++) {
            if (f[i] > aux) {
                aux = f[i];
            }

        }
        return aux;
    }

    public double ObtenerBaja(double[] f, double lower) {
        double aux = f[0];
        int i;
        for (i = 0; i < celcius.length; i++) {
            if (f[i] < aux) {
                aux = f[i];
            }

        }
        return aux;
    }
}