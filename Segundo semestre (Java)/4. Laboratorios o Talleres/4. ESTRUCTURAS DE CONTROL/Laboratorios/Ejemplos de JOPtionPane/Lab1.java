import javax.swing.JOptionPane;

class Tierra {
	int edadc;

	void asignar(int eda) {
		edadc = eda;
	}

	double calcularM() {
		double y = 0;

		y = (edadc * 365) / 88;
		return y;
	}

	double calcularV() {
		return (edadc * 365) / 225;
	}

	double calcularJ() {
		return (edadc * 365) / 4380;
	}
}

public class Lab1 {
	public static void main(String args[]) {
		String input;
		int edad;
		Tierra obj = new Tierra();

		input = JOptionPane.showInputDialog(" Introduzca la edad en la tierra");
		edad = Integer.parseInt(input);
		obj.asignar(edad);

		JOptionPane.showMessageDialog(null, "Edad en Mercurio:  " + obj.calcularM(), "SALIDA",
				JOptionPane.INFORMATION_MESSAGE);

		JOptionPane.showMessageDialog(null, "Edad en Venus:  " + obj.calcularV(), "ADVERTENCIA",
				JOptionPane.WARNING_MESSAGE);

		JOptionPane.showMessageDialog(null, "Edad en Jupiter: " + obj.calcularJ(), "ERROR", JOptionPane.ERROR_MESSAGE);

	}
}
