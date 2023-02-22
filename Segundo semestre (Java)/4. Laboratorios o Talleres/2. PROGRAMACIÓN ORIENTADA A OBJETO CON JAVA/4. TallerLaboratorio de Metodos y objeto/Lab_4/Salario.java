package Lab_4;
public class Salario{

private double horasT;
private double TarifaH;
private String ced;

public double getHorasT() {
    return horasT;
}

public void setHorasT(double horasT) {
    this.horasT = horasT;
}

public double getTarifaH() {
    return TarifaH;
}

public void setTarifaH(double tarifaH) {
    TarifaH = tarifaH;
}

public String getCed() {
    return ced;
}

public void setCed(String ced) {
    this.ced = ced;
}


public double CalcularS(double sala){

    double s = horasT*TarifaH;
    return s;

}

public double CalcularB(double s){
    
    double b = s*20/100;
    return b;
}
}