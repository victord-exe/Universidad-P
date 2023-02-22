public class Calculo{

    private double x;
    private int n;

    public double getValorx(){
        return x;
    }

    public int getValorn(){
        return n;
    }
    public void setValores(double x, int n){
        this.x=x;
        this.n=n;
    }

    public double calculoPotencia()
    {
        double resultado = x;

        for(int i=1;i<n;i=i+1){
            resultado = resultado*x;
        }
        if (n==0)
        {
            resultado = 1;
        }
        return(resultado);
    }
 }


