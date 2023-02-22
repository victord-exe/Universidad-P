public class Ordenletras{

    private char caracter1, caracter2;

    public char getValorc1(){
        return caracter1;
    }

    public char getValorc2(){
        return caracter2;
    }
    public void setValores(char caracter1, char caracter2){
        this.caracter1=caracter1;
        this.caracter2=caracter2;
    }

    public boolean orden()
    {
        boolean ordenalfabetico = false;

        if (caracter1<caracter2)
        {
            ordenalfabetico = true;
        }else{
            ordenalfabetico = false;
        }

        return(ordenalfabetico);
    }
 }


