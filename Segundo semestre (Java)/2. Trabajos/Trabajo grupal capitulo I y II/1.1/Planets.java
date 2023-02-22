public class Planets {

    private String nombre;
    private String tipo;
    private int cantsat;
    private double masa;
    private double volumen;
    private int diametro;
    private int distmedia;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getCantsat() {
        return cantsat;
    }
    public void setCantsat(int cantsat) {
        this.cantsat = cantsat;
    }
    public double getMasa() {
        return masa;
    }
    public void setMasa(double masa) {
        this.masa = masa;
    }
    public double getVolumen() {
        return volumen;
    }
    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }
    public int getDiametro() {
        return diametro;
    }
    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }
    public int getDistmedia() {
        return distmedia;
    }
    public void setDistmedia(int distmedia) {
        this.distmedia = distmedia;
    }

    public double Calculard() {
        return masa / volumen;
    }

    public String TipoP() {
        if ((nombre == "Mercurio") || (nombre == "Venus") || (nombre == "Tierra") || (nombre == "Marte"))
            return tipo = "Rocoso";
        else
            return tipo = "Gaseoso";
    }
}

/*
 * Se requiere un programa que modele el concepto de los planetas del sistema
 * solar. Los
 * planetas tiene los siguientes atributos:
 * Un nombre de tipo String con valor inicial de null,
 * cantidad de satélites de tipo int con valor inicial de cero.
 * masa en kilogramos de tipo double con valor inicial de cero,
 * Volumen en kilómetros cúbicos de tipo double con valor inicial de cero,
 * diámetro en kilómetros de tipo int con valor inicial de cero,
 * distancia media al Sol en millones de kilómetros, de tipo int con valor
 * inicial de cero,
 * tipo de planeta de acuerdo con su tamaño.
 * 
 * La clase debe incluir los siguientes métodos:
 * • La clase debe tener un constructor que inicialice los valores de sus
 * respectivos atributos.
 * • Calcular la densidad del planeta, como el cociente entre su masa y su
 * volumen.
 * • En un método main se deben crear dos planetas y mostrar los valores de sus
 * atributos en
 * pantalla. Además, se debe imprimir la densidad de cada planeta.
 * Se pide el ADOO, el programa completo y la construcción de uno de los objetos
 * creados
 */