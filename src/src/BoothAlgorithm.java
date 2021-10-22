import java.util.*;

public class BoothAlgorithm {
    public final int MAX_BIT=8;


    public static void Reverse(int[] arr){
        int start=0;
        int end= arr.length-1;
        while (start<end){
            int temp= arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            ++start;
            --end;
        }
    }
    public static int[] DetermineConversionFromUserNumber(int number){

        if(number>=0){

            int[] binary= ConvertIntToBinary(number);
            Reverse(binary);
            return binary;
        }
        else{
            int[] binary= ConvertIntToBinary(number*-1);
             binary= NumberInTwoComplement(binary);
            Reverse(binary);
            return binary;


        }
    }


    public static int[] NumberInTwoComplement(int[] twoComplement){
        //assume is postive for now then change the bits later
        /*System.out.println("Number after conversion");

        for(int i: twoComplement){
            System.out.print(i + " ");
        }*/
        System.out.println();
        //flip the bits :)
        for(int i=0; i<twoComplement.length;++i){
            if(twoComplement[i]==0){
                twoComplement[i]=1;
            }
            else{
                twoComplement[i]=0;
            }
            //System.out.print(twoComplement[i]+ " ");
        }
       // System.out.println();



        boolean carry=true;
        //do the magic of adding
        int firstNumber= twoComplement[0];
        if(firstNumber==0){
            carry=false;
        }
        else{
            twoComplement[0]=0;
            carry=true;
        }
        for(int i=1; i<twoComplement.length && carry;++i){
            int currentNumber= twoComplement[i];
            if(currentNumber==0){
                if(carry){
                    carry=false;
                    twoComplement[i]=1;
                }

            }
            else{
                if(carry){
                    twoComplement[i]=0;
                    carry=true;
                }
                else{
                    twoComplement[i]=1;
                    carry=false;
                }
            }
        }




        return twoComplement;

    }
    public static void ShiftRight(int[] firstNumber, int[] secondNumber){
        int signNumber= firstNumber[0];
        int carryOverNumber=firstNumber[firstNumber.length-1];
       // System.out.println("first number after shift ");
        for(int i=0; i<firstNumber.length-1; ++i){
            firstNumber[i+1]=firstNumber[i];
//
        }
        firstNumber[0]=signNumber;
       for (int i: firstNumber ){
           System.out.print(i + " ");
       }

       for(int i=0; i<secondNumber.length-1;++i){
            secondNumber[i+1]=secondNumber[i];
       }
       secondNumber[0]=carryOverNumber;
       System.out.print(" ");
      // System.out.println("Second number after shift");
        for (int i: secondNumber ){
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }
    public static int[] Add(int [] firstBinaryNumber, int[] secondBinaryNumbers){
        int addedNumber[]= new int[8];
        int addedNumberIndex=0;
         boolean carry=false;
        for(int i= firstBinaryNumber.length-1; i>=0; --i){
            int firstNum=firstBinaryNumber[i];
            int secondNum= secondBinaryNumbers[i];
            if(firstNum==0 && secondNum==0){
                if(carry){
                    addedNumber[addedNumberIndex++]=1;
                    carry=false;
                }
                else{
                    addedNumber[addedNumberIndex++]=0;
                    carry=false;
                }

            }
            else if((firstNum==1 && secondNum==0) || (secondNum==1 && firstNum==0)){
                if(carry){
                    carry=true;
                    addedNumber[addedNumberIndex++]=0;
                }
                else{
                    carry=false;
                    addedNumber[addedNumberIndex++]=1;

                }
            }
            else{
                //1 1

                    carry=true;
                    addedNumber[addedNumberIndex++]=0;


                }
            }
        Reverse(addedNumber);
        return addedNumber;
        }








    public static int[] ConvertIntToBinary(int number){
        int numberAsBinary[]= new int[8];

        // Built-In Java Function that converts int to a binary string
        //  TODO: This does not fully work normally with negative numbers yet

        //should return an array rep of the binary number
       // String result = Integer.toBinaryString(number);

        //String resultWithPadding = String.format("%8s", result).
          //      replaceAll(" ", "0");  // 8-bit Integer
        int i=0;
        while(number>0){
            numberAsBinary[i]= number%2;
            number/=2;
            ++i;
        }
        int numberOfZeros=8-i;
        for(int j=0; j<numberOfZeros;++j){
            numberAsBinary[i]=0;
            ++i;
        }

        //reverse the array
        return numberAsBinary;
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

       int numberOneAsBinary[]= new int[8];
       int numberTwoasBinary[]= new int[8];


        System.out.println("hello cole");
        System.out.println("Hello Ben!");
        System.out.println("I feel nothing but pain :)");
        System.out.println("Turn to the Darkside young Padawan ;)");

        Scanner src= new Scanner(System.in);
        System.out.println("Please Enter the Multiplicand");
        numberOne=src.nextInt();
        System.out.println("Please Enter the Multiplier");
        numberTwo=src.nextInt();
         //numberOneAsBinary=ConvertIntToBinary(numberOne);
        //numberTwoasBinary=ConvertIntToBinary(numberTwo);

         /*System.out.println("first number "+ numberOne+" as a binary number is: "+ numOneAsString +
                 " and the second number "+ numberTwo+" a binary number is: "+ numTwoAsString);*/

         // DisplayTable(numOneAsString);
         //testing to make sure numbers work
         numberOneAsBinary=DetermineConversionFromUserNumber(numberOne);
         numberTwoasBinary= DetermineConversionFromUserNumber(numberTwo);
         //System.out.println("Number One "+ numberOne + " as binary");
        // for(int i: numberOneAsBinary){
           //  System.out.print(i + " ");
      //   }
         /*System.out.println();

         System.out.println("Number Two "+ numberTwo + " as binary");
         for(int i: numberTwoasBinary){
             System.out.print(i + " ");
         }*/

         ShiftRight(numberOneAsBinary,numberTwoasBinary);
         //System.out.println();
         //System.out.println();



     }
}
