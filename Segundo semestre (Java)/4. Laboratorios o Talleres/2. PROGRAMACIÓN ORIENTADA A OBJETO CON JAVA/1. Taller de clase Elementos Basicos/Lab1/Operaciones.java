public class Operaciones{

    private int num1;
    private int num2;
    public static void main(String[] args) {

   } 
   
    public int getNum1() {
      return num1;
    }

    public void setNum1(int num1) {
       this.num1 = num1;
    }
    public int getNum2() {
       return num2;
    }
    public void setNum2(int num2) {
       this.num2 = num2;
    }
    
    public int sumar (){
       return num1+num2;
    }
    
    public int restar (){
       return num1-num2;
    }
    
    public int multiplicar (){
       return num1*num2;
      }
}
