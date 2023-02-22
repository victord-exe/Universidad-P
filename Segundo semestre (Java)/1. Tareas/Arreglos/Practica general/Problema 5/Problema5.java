public class Problema5{
    private double arr[];

    public double[] getArr() {
        return arr;
    }

    public void setArr(double[] arr) {
        this.arr = arr;
    }
    
    public int ContarN(int nNega){
        int i;
        for (i=0; i < arr.length; i++){
            if(arr[i]<0){
                nNega +=1;
            }
        }
        return nNega;
    }

    public int ContarPosi(int nPosi){
        int i;
        for (i=0; i < arr.length; i++){
            if (arr[i]>0){
                nPosi +=1;
            }
        }
        return nPosi;
    }

    public int ContarCeros(int nCeros){
        int i;
        for (i=0; i < arr.length; i++){
            if (arr[i] == 0){
                nCeros +=1;
            }
        }
        return nCeros;
    }

    public double AcumularNega(double totNega){
        int i;
        for (i=0; i < arr.length; i++){
            if (arr[i] < 0){
                totNega += arr[i];
            }
        }
        return totNega;
    }
    
    public double AcumularPosi(double totPosi){
        int i;
        for (i=0; i < arr.length; i++){
            if (arr[i] > 0){
                totPosi += arr[i];
            }
        }
        return totPosi;
    }
}

