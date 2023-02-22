public class Lab1 {                              // ambito de la clase lab1
    public static void main(String[] args) {      // static: no requiere de un objeto para ser llamado

        double y = 15.92;                         // Void: No retorna valor
                                                  // Main: porque la MVJ es lo que va a buscar en el programa.
        Ecuacion obj = new Ecuacion();
        System.out.println("X = " + obj.traerX());
        System.out.println("Y = " + y);

    }
}
