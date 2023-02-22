import java.io.*;

class Salida {
	String ced;
	double notaf;
}

class Notas {

	private String nom, ced;
	private double notaP[];

	Notas() {
		notaP = new double[4];
	}

	void asignar(String no, String c, double n[]) {
		nom = no;
		ced = c;
		notaP = n;
	}

	void ordenar() {
		int i, j;
		// BLOQUE DE INSTRUCCIONES
		i = 0;
		double temp;
		do {
			for (j = i + 1; j < notaP.length; j = j + 1)
				if (notaP[i] < notaP[j]) {
					temp = notaP[i];
					notaP[i] = notaP[j];
					notaP[j] = temp;
				}
			i = i + 1;
		} while (i < 3);
		for (j = 0; j < 4; j++)
			System.out.println("En Ordenar" + notaP[j]);
	}

	double calcularN() {
		double not = 0.00;
		int f;
		for (f = 0; f < 3; f++)
			not = not + notaP[f];
		return not / 3;
	}

	String traerN() {
		return nom;
	}

	String traerC() {
		return ced;
	}

	double[] traerNo() {
		return notaP;
	}
}

public class ArregloObjeto {

	public static void main(String[] args) {
		int f, j;
		boolean leido = true, n1 = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double notas[] = new double[4];
		double notfin = 0;
		Notas obj = new Notas();
		Salida respu[] = new Salida[3];
		for (f = 0; f < respu.length; f++)
			respu[f] = new Salida();
		for (f = 0; f < respu.length; f++)
			System.out.println(respu[f].ced + respu[f].notaf);
		String nom = "", ced = "";

		for (f = 0; f < respu.length; f++) {
			do {
				try {
					do {
						try {
							System.out.println("lea el nombre");
							nom = br.readLine();
							n1 = nom.matches("^[a-zA-Z]+$");
						} catch (IOException e) {
							System.out.println("error");
						}
					} while (n1 == false);
					try {
						System.out.println("lea la cedula");
						ced = br.readLine();
					} catch (IOException e) {
						System.out.println("Error");
					}
					for (j = 0; j < notas.length; j++) {
						do {
							try {
								leido = true;
								System.out.println("lea la nota");
								notas[j] = Double.parseDouble(br.readLine());
								if (notas[j] < 0.0 || notas[j] > 100) {
									System.out.println("Ingrese una nota valida");
									leido = false;
								}
							} catch (NumberFormatException er) {
								leido = false;
								System.out.println("error");
							} catch (IOException e) {
								System.out.println("Error");
							}
						} while (!leido);
					}
					obj.asignar(nom, ced, notas);
					obj.ordenar();
					notfin = obj.calcularN();
					respu[f].ced = obj.traerC();
					respu[f].notaf = notfin;
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Error");
					leido = false;
				}
			} while (!leido);
		}

		System.out.println("\n  CEDULA            NOTA FINAL");
		for (j = 0; j < respu.length; j++)
			System.out.println(respu[j].ced + "     " + respu[j].notaf);
	}
}
