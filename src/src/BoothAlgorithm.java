import java.util.Scanner;

public class BoothAlgorithm {
    public static String ConvertIntToBinary(int number){

        // Built-In Java Function that converts int to a binary string
        //  TODO: This does not fully work normally with negative numbers yet
        String result = Integer.toBinaryString(number);

        String resultWithPadding = String.format("%8s", result).
                replaceAll(" ", "0");  // 8-bit Integer

        return  resultWithPadding;
    }

    public static void DisplayTable(String MCand)
    {
        System.out.println("Iteration | Step        | Multiplicand      | Product");
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
        System.out.println("Please Enter the Multiplicand");
        numberOne=src.nextInt();
        System.out.println("Please Enter the Multiplier");
        numberTwo=src.nextInt();
        numOneAsString=ConvertIntToBinary(numberOne);
        numTwoAsString=ConvertIntToBinary(numberTwo);

         System.out.println("first number "+ numberOne+" as a binary number is: "+ numOneAsString +
                 " and the second number "+ numberTwo+" a binary number is: "+ numTwoAsString);

        DisplayTable(numOneAsString);


    }
}
