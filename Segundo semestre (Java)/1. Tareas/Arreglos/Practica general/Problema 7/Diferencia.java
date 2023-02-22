class Diferencia {

    private int m[];
    private int n[];

    public void setM(int m[]) {
        this.m = m;
    }

    public void setN(int n[]) {
        this.n = n;
    }

    public int[] getM() {
        return m;
    }

    public int[] getN() {
        return n;
    }

    public String diferenciar(int i) {
        String diff;

        if (m[i] == n[i]) {
            diff = "IGUALES";
        } else {
            diff = "DIFERENTES";
        }
        return diff;
    }
}