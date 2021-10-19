import java.util.Scanner;

public class BoothAlgorithm {
    public static String ConvertIntToBinary(int number){
        if(number>=0){

        }
        else{

        }
        return null;
    }

     public static void main(String[] args) {
       int numberOne=0;
       int numberTwo=0;
       String numOneAsString;
       String numTwoAsString;

        System.out.println("hello cole");
        System.out.println("Hello Ben!");

        Scanner src= new Scanner(System.in);
        System.out.println("Enter your first number");
        numberOne=src.nextInt();
        System.out.println("Enter your second number");
        numberTwo=src.nextInt();
        System.out.println("first number: "+ numberOne + "second number "+ numberTwo);
        numOneAsString=ConvertIntToBinary(numberOne);
        numTwoAsString=ConvertIntToBinary(numberTwo);


    }
}
