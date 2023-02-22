package Problema1;

public class Conversion {

    private int decimal;

    public void asignar(int decimal) {
        this.decimal = decimal;
    }

    public String convertirOctal() {
        String octal=" ";
        octal = Integer.toOctalString(decimal);
        return octal;

    }

    public String convertirHexadecimal() {
        String hexadecimal = " ";
        hexadecimal = Integer.toHexString(decimal);
        return hexadecimal;
    }

    public double traerDecimal() {
        return decimal;
    }

}
