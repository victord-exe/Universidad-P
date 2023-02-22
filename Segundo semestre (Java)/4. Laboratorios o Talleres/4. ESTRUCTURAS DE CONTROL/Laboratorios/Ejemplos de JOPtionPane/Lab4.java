import javax.swing.JOptionPane;

class Salarios {
  private double sal1, sal2, sal3;
  private String clave;

  public void asignar(String c, double s1, double s2, double s3) {
    sal1 = s1;
    clave = c;
    sal2 = s2;
    sal3 = s3;
  }

  double calcularI() {
    return (sal1 + sal2 + sal3);
  }

  double calcularP(double ingreso) {
    return ingreso / 3;
  }

  String traer() {
    return clave;
  }

  double traerS1() {
    return sal1;
  }

  double traerS2() {
    return sal2;
  }

  double traerS3() {
    return sal3;
  }
}

public class Lab4 {
  public static void main(String[] args) {
    double s1 = 0, s2 = 0, s3 = 0, ingre = 0;
    Salarios obj = new Salarios();
    int n = 0;
    String clave;
    boolean leido = true;

    while (n == JOptionPane.YES_NO_OPTION) {

      clave = JOptionPane.showInputDialog("Lea la clave");
      do {

        try {
          leido = true;
          s1 = Double.parseDouble(JOptionPane.showInputDialog(" Lea el salario 1"));
          if (s1 <= 0) {
            JOptionPane.showMessageDialog(null, "Salario no puede ser negativo");
            leido = false;
          }
        } catch (NumberFormatException e) {
          leido = false;
          JOptionPane.showMessageDialog(null, "error de conversion");
        }
      } while (!leido);

      do {

        try {
          leido = true;

          s2 = Double.parseDouble(JOptionPane.showInputDialog(" Lea el salario 2"));
          if (s2 <= 0) {
            JOptionPane.showMessageDialog(null, "Salario no puede ser negativo");
            leido = false;
          }
        }

        catch (NumberFormatException e) {
          leido = false;
          JOptionPane.showMessageDialog(null, "error de conversion");
        }
      } while (!leido);

      do {

        try {
          leido = true;
          s3 = Double.parseDouble(JOptionPane.showInputDialog(" Lea el salario 3"));
          if (s3 <= 0) {
            JOptionPane.showMessageDialog(null, "Salario no puede ser negativo");
            leido = false;
          }
          obj.asignar(clave, s1, s2, s3);
          ingre = obj.calcularI();
          JOptionPane.showMessageDialog(null,
              "\n\nCLAVE: " + obj.traer() + "\n INGRESO: " + ingre + "\nPROMEDIO:" + obj.calcularP(ingre));
        } catch (NumberFormatException e) {
          leido = false;
          JOptionPane.showMessageDialog(null, "error de conversion");
        }
      } while (!leido);
      n = JOptionPane.showConfirmDialog(null, "DESEA PROCESAR OTRO REGISTRO",
          "", JOptionPane.YES_NO_OPTION);

    }
  }
}