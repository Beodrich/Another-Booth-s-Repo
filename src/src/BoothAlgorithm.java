import java.util.Scanner;

public class BoothAlgorithm {
    public static String ConvertIntToBinary(int number){

        // Built-In Java Function that converts int to a binary string
        String result = Integer.toBinaryString(number);

        String resultWithPadding = String.format("%4s", result).
                replaceAll(" ", "0");  // 4-bit Integer

        return  resultWithPadding;
    }

    public static void DisplayTable(String MCand)
    {
        System.out.println("Iteration | Step        | Multiplicand  | Product");
        for(int i = 0; i <=8; i++)
        {
            System.out.println("_______________________________________________________");
            System.out.println(i + "         | Step        | "+MCand+"          | Product");
        }
    }

     public static void main(String[] args) {
       int numberOne=0;
       int numberTwo=0;
       String numOneAsString;
       String numTwoAsString;

        System.out.println("hello cole");
        System.out.println("Hello Ben!");

        Scanner src= new Scanner(System.in);
        System.out.println("Please Enter your first number");
        numberOne=src.nextInt();
        System.out.println("Please Enter your second number");
        numberTwo=src.nextInt();
        numOneAsString=ConvertIntToBinary(numberOne);
        numTwoAsString=ConvertIntToBinary(numberTwo);


        //numOneAsString = Integer.toBinaryString(numberOne);
        //numTwoAsString = Integer.toBinaryString(numberTwo);

         System.out.println("first number "+ numberOne+" as a binary number is: "+ numOneAsString +
                 " and the second number "+ numberTwo+" a binary number is: "+ numTwoAsString);


        DisplayTable(numOneAsString);


    }
}
