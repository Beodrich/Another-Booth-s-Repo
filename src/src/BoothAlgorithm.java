import java.awt.print.Printable;
import java.lang.reflect.Array;
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
    public static void BinaryToDecimal(int[]first, int[]second){
   String combo="";
   boolean isNegative=false;
   int[] comboArray= new int[first.length+ second.length];
   int index= second.length-1;
   for(int i=0; i< first.length;++i){
       comboArray[i]= first[i];
       comboArray[index+1]= second[i];
       ++index;
   }
  if(comboArray[0]==1){
      comboArray=NumberInTwoComplement(comboArray);
      isNegative=true;
  }

  int currentIndex=0;
  int num=0;
    for(int i=comboArray.length-1; i>=0; --i){
        num+=comboArray[i]* Math.pow(2,currentIndex);
        currentIndex++;
    }
    if(isNegative){
        num*=-1;
    }
    System.out.println(" the num is "+ num);




       // System.out.println("the decimal number is "+ (int)dec);



    }
    public static int[] DetermineConversionFromUserNumber(int number){
        if(number>=0){
            int[] binary= ConvertIntToBinary(number);
            Reverse(binary);
            return binary;
        }
        else{
            int[] binary= ConvertIntToBinary(number*-1);
            Reverse(binary);
            binary= NumberInTwoComplement(binary);
            return binary;
        }
    }

    public static int[] NumberInTwoComplement(int[] numberToConvert){
        //assume is postive for now then change the bits later
        //flip the bits :)
        int oneComp[]= new int[numberToConvert.length];
        for(int i=0; i<numberToConvert.length;++i){
            if(numberToConvert[i]==0){
                oneComp[i]=1;
            }
            else{
                oneComp[i]=0;
            }
        }
        int finalNumber[]= new int[numberToConvert.length];
        boolean carry=true ;
        //do the magic of adding
        for(int i=oneComp.length-1; i>=0;--i){
            int currentNumber= oneComp[i];
            if(currentNumber==1 && carry){
                finalNumber[i]=0;
            }
            else if(currentNumber==0 && carry ){
                carry=false;
                finalNumber[i]=1;
            }
            else{
                finalNumber[i]= oneComp[i];
            }
            //this would be the 0 + 1 case
            /*if(currentNumber==0){
                if(carry){

                    twoComplement[i]=1;
                    break;
                }

            }
            //this would be the 1 +1 case
            else{
                if(carry){
                    twoComplement[i]=0;
                    carry=true;
                }
                else{
                    twoComplement[i]=1;
                    break;
                }
            }*/
        }
        return finalNumber;
    }

    public static void ShiftRight(int[] firstNumber, int[] secondNumber){
        int signNumber = firstNumber[0];
        int carryOverNumber = firstNumber[firstNumber.length - 1];

        for (int i = firstNumber.length - 1; i >= 1; i--) {
            firstNumber[i] = firstNumber[i - 1];
        }
        firstNumber[0] = signNumber;
        /*for (int i : firstNumber) {
            System.out.print(i + " ");
        }
        System.out.print(" ");*/

        for (int i = secondNumber.length - 1; i >= 1; i--) {
            secondNumber[i] = secondNumber[i - 1];
        }
        secondNumber[0] = carryOverNumber;
        /*for (int i : secondNumber) {
            System.out.print(i + " ");
        }
        System.out.println(" ");*/
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
    public static String PrintArray(int[] number){
        String num="";
        for(int i: number){
            num+=i;
        }
        return num;
    }
    public static void DisplayTable(int currentIteration, String step,int[]mcand,
                                    int[]A_productFirst, int[]A_productSecond,
                                    int[]B_productFirst, int[]B_productSecond) {


        System.out.println("_______________________________________________________________________");
        System.out.println(currentIteration + "         |     " + step + "    | "+ PrintArray(mcand)+ "\t   | "
                + PrintArray(B_productFirst)+ " " +PrintArray(B_productSecond));
        if(currentIteration != 0){
            System.out.println("          |     ASR 1              | "+ PrintArray(mcand)+ "\t   | "
                    + PrintArray(A_productFirst)+ " " +PrintArray(A_productSecond));
        }
    }

    public static void DoTheBooth(int[]mCand, int[]multi){
        System.out.println("Iteration |      Step              | Multiplicand  | Product");
        int[] secondHalf= new int[9];
        int[] firstHalf= new int[8];

        int[] B_secondHalf= new int[9];
        int[] B_firstHalf= new int[8];
        String step="";
        for(int i=0; i<8; ++i){
            secondHalf[i]=multi[i];
        }
        secondHalf[8]=0;
        DisplayTable(0, "Init           ",mCand,firstHalf,secondHalf,firstHalf,secondHalf);
        for(int i=0; i<8;++i){
            //0 1 and 1 0
            int firstNum= secondHalf[secondHalf.length-2];
            int secondNum= secondHalf[secondHalf.length-1];
            if(firstNum==1 && secondNum==0){
                firstHalf=Add(firstHalf,NumberInTwoComplement(mCand));
                step="Prod=Prod-Mcand";
            }
            else if(firstNum==0 && secondNum==1){
                firstHalf=Add(firstHalf,mCand);
                step="Prod=Prod+Mcand";
            }
            else{
                step="No Operation   ";
            }
            B_firstHalf = firstHalf.clone();
            B_secondHalf = secondHalf.clone();
            ShiftRight(firstHalf,secondHalf);
            DisplayTable(i+1,step,mCand,firstHalf,secondHalf, B_firstHalf, B_secondHalf);


        }
        System.out.println("_______________________________________________________________________");
        System.out.println("Our Final Product is: ");
        for(int i: firstHalf){
            System.out.print(i + " ");
        }
        System.out.print(" ");
        for(int i=0; i<8;++i){
            System.out.print(secondHalf[i] + " ");
        }
        System.out.println();
        System.out.println();
        BinaryToDecimal(firstHalf,Arrays.copyOf(secondHalf,secondHalf.length-1));
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
        System.out.println("Hello Darkness my old friend ");

        Scanner src= new Scanner(System.in);
        System.out.println("Please Enter the Multiplicand");
        numberOne=src.nextInt();
        System.out.println("Please Enter the Multiplier");
        numberTwo=src.nextInt();
        //numberOneAsBinary=ConvertIntToBinary(numberOne);
        //numberTwoasBinary=ConvertIntToBinary(numberTwo);

        //System.out.println("first number "+ numberOne+" as a binary number is: "+ numOneAsString +
        //  " and the second number "+ numberTwo+" a binary number is: "+ numTwoAsString);*/

        // DisplayTable(numOneAsString);
        //testing to make sure numbers work
        numberOneAsBinary=DetermineConversionFromUserNumber(numberOne);
        numberTwoasBinary= DetermineConversionFromUserNumber(numberTwo);
         /*System.out.println("Number One "+ numberOne + " as binary");
         for(int i: numberOneAsBinary){
             System.out.print(i + " ");
         }
         System.out.println();

         System.out.println("Number Two "+ numberTwo + " as binary");
         for(int i: numberTwoasBinary){
             System.out.print(i + " ");
         }
         System.out.println();
         System.out.println("Shifted Right is:");
         ShiftRight(numberOneAsBinary,numberTwoasBinary);*/
        DoTheBooth(numberOneAsBinary,numberTwoasBinary);
    }
}
