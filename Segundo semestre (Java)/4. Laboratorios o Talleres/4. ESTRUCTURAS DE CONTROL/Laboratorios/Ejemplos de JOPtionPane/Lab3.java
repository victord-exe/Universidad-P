
import javax.swing.*;

public class Lab3 {

  /**
   * Creates a new instance of <code>Imagenes</code>.
   */

  public static void main(String[] args) {
    String ima[] = { "tinker.jpg", "java.jpg", "ovej4.jpg", "osito3.jpg" }; // arreglo de imagenes jpg
    int i;
    for (i = 0; i <= 3; i++) {
      ImageIcon imagen = new ImageIcon(ima[i]);// ImageIcon permite cargar la imagen en una aplicacion enJava
      JOptionPane.showMessageDialog(null, imagen);
    }
  }
}
