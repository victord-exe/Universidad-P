class Nomina{

private String ced;
private double sal;

public String getCed() {
    return ced;
}

public void setCed(String ced) {
    this.ced = ced;
}

public double getSal() {
    return sal;
}

public void setSal(double sal) {
    this.sal = sal;
}


public double calcularProme(double tot, int cantP){
    double prom;
    prom = tot/cantP;
    return prom; //retorna el promedio de los salarios
}
public double calcularMayor(double nomi, int cantP){
    return nomi/cantP;
}
}