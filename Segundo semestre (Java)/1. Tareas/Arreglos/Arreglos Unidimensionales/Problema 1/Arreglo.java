public class Arreglo {
    private int num;
    private int tamaño;
    /*
     * public Arreglo(int n){
     * int[] array = new int[n];
     * }
     */

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    public int[] Cargar(int[] array) {
        int i;
        for (i = 0; i<array.length;i++){
            array[i] = (i+1) * num;
        }
        return array;
    }



}