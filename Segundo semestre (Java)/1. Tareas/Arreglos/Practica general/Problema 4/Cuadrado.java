class Cuadrado {
    private int n[];

    public void setArray(int n[]) {
        this.n = n;
    }

    public int[] getArray() {
        return n;
    }

    public void calcularEleva(double array[]) {
        int x;
        for (x = 0; x < n.length; x++) {
            array[x] = Math.pow(n[x], 2);
        }
    }
}