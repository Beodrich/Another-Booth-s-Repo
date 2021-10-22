import java.util.*;

public class BoothAlgorithm {
    public final int MAX_BIT = 8;

    public static void Reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            ++start;
            --end;
        }
    }

    public static int[] DetermineConversionFromUserNumber(int number) {
        if (number >= 0) {
            int[] binary = ConvertIntToBinary(number);
            Reverse(binary);
            return binary;
        } else {
            int[] binary = ConvertIntToBinary(number * -1);
            binary = NumberInTwoComplement(binary);
            Reverse(binary);
            return binary;
        }
    }

    public static int[] NumberInTwoComplement(int[] twoComplement) {
        //assume is postive for now then change the bits later
        //flip the bits :)
        for(int i=0; i<twoComplement.length;++i){
            if(twoComplement[i]==0){
                twoComplement[i]=1;
            }
            else{
                twoComplement[i]=0;
            }
        }
        boolean carry = true;
        //do the magic of adding
        int firstNumber = twoComplement[0];
        if (firstNumber == 0) {
            carry = false;
        } else {
            twoComplement[0] = 0;
            carry = true;
        }
        for (int i = 1; i < twoComplement.length && carry; ++i) {
            int currentNumber = twoComplement[i];
            if (currentNumber == 0) {
                if (carry) {
                    carry = false;
                    twoComplement[i] = 1;
                }
            } else {
                if (carry) {
                    twoComplement[i] = 0;
                    carry = true;
                } else {
                    twoComplement[i] = 1;
                    carry = false;
                }
            }
        }
        return twoComplement;
    }
    // Shifts the 2 int arrays over (Product) over ASR 1
    public static void ShiftRight( int[] firstNumber, int[] secondNumber){
        int signNumber = firstNumber[0];
        int carryOverNumber = firstNumber[firstNumber.length - 1];

        for (int i = firstNumber.length - 1; i >= 1; i--) {
            firstNumber[i] = firstNumber[i - 1];
        }
        firstNumber[0] = signNumber;
        for (int i : firstNumber) {
            System.out.print(i + " ");
        }
        System.out.print(" ");

        for (int i = secondNumber.length - 1; i >= 1; i--) {
            secondNumber[i] = secondNumber[i - 1];
        }
        secondNumber[0] = carryOverNumber;
        for (int i : secondNumber) {
            System.out.print(i + " ");
        }
    }

    public static int[] Add ( int[] firstBinaryNumber, int[] secondBinaryNumbers){
        int addedNumber[] = new int[8];
        int addedNumberIndex = 0;
        boolean carry = false;
        for (int i = firstBinaryNumber.length - 1; i >= 0; --i) {
            int firstNum = firstBinaryNumber[i];
            int secondNum = secondBinaryNumbers[i];
            if (firstNum == 0 && secondNum == 0) {
                if (carry) {
                    addedNumber[addedNumberIndex++] = 1;
                    carry = false;
                } else {
                    addedNumber[addedNumberIndex++] = 0;
                    carry = false;
                }
            } else if ((firstNum == 1 && secondNum == 0) || (secondNum == 1 && firstNum == 0)) {
                if (carry) {
                    carry = true;
                    addedNumber[addedNumberIndex++] = 0;
                } else {
                    carry = false;
                    addedNumber[addedNumberIndex++] = 1;
                }
            } else {
                // 1 to 1
                carry = true;
                addedNumber[addedNumberIndex++] = 0;
            }
        }
        Reverse(addedNumber);
        return addedNumber;
    }

    public static int[] ConvertIntToBinary ( int number){
        int numberAsBinary[] = new int[8];
        int i = 0;
        while (number > 0) {
            numberAsBinary[i] = number % 2;
            number /= 2;
            ++i;
        }
        int numberOfZeros = 8 - i;
        for (int j = 0; j < numberOfZeros; ++j) {
            numberAsBinary[i] = 0;
            ++i;
        }
        //reverse the array
        return numberAsBinary;
    }

    public static void DisplayTable ( int MCand, int Multiplier, int Product){
        System.out.println("Iteration | Step        | Multiplicand      | Product");
        for (int i = 0; i <= 8; i++) {
            System.out.println("_______________________________________________________");
            System.out.println(i + "         | " + Multiplier + "         | " + MCand + "          | " + Product);
        }
    }

    public static void Booths ()
    {
        // Da Da DAAAAAAAAAA
    }

    public static void main (String[]args){
        int numberOne = 0;
        int numberTwo = 0;

        int numberOneAsBinary[] = new int[8];
        int numberTwoasBinary[] = new int[8];

        Scanner src = new Scanner(System.in);
        System.out.println("Please Enter the Multiplicand");
        numberOne = src.nextInt();
        System.out.println("Please Enter the Multiplier");
        numberTwo = src.nextInt();

        // DisplayTable(numOneAsString);

        numberOneAsBinary = DetermineConversionFromUserNumber(numberOne);
        numberTwoasBinary = DetermineConversionFromUserNumber(numberTwo);


        System.out.println("Number One " + numberOne + " as binary");
        for (int i : numberOneAsBinary) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Number Two " + numberTwo + " as binary");
        for (int i : numberTwoasBinary) {
            System.out.print(i + " ");
        }
        System.out.println();
    /*
     System.out.println("Numbers added together");
     int[] add= Add(numberOneAsBinary,numberTwoasBinary);
     for(int i: add){
         System.out.print(i + " ");

     }
     */
        ShiftRight(numberOneAsBinary,numberTwoasBinary);
    }
}
