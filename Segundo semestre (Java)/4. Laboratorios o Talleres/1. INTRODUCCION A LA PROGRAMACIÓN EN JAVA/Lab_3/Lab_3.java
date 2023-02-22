package Lab_3;

public class Lab_3 {
    public static void main(String[] args) {

        Email2 victor = new Email2();

        System.out.println("Contraseña: " + victor.getContrasena());

        victor.setContrasena("elvitor!");
        victor.setUsuario("Victorcito");
        System.out.println("Usuario: " + victor.getUsuario());
        System.out.println("Contrasena: " + victor.getContrasena());

    }
}
