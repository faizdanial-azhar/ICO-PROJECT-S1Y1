package com.mycompany.ico_project;

import java.util.Scanner;

public class arithmetic {
    public static void main(String[] args) {            // Main method with user input
        Scanner scanner = new Scanner(System.in);
        
        try {
            while (true) {
                System.out.println("\n=== Binary Operations Calculator ===");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("Exit");
                System.out.println("Heelo");
                
                System.out.print("Choose an option: ");

                
                String input = scanner.nextLine();

                if(input.equalsIgnoreCase("exit")){
                    System.out.println("Goodbye!");
                    break;
                }
                
                int choice = Integer.parseInt(input);

                if (choice == 1) {                                          //addition
                    System.out.println("\n*************************************************");
                    System.out.println("Addition selected.");
                    System.out.print("Enter first number (decimal): ");
                    int num1 = scanner.nextInt();
                    
                    System.out.print("Enter second number (decimal): ");
                    int num2 = scanner.nextInt();
                    
                    // Convert to binary and perform operations
                    String bin1 = decimalToBinary(num1);
                    String bin2 = decimalToBinary(num2);
                    
                    System.out.println("\nResults:");
                    System.out.println("First number (" + num1 + ") in binary: " + bin1);
                    System.out.println("Second number (" + num2 + ") in binary: " + bin2);
                    
                    String sum = addBinary(bin1, bin2);
                    int decimalSum = binaryToDecimal(sum);
                    
                    System.out.println("Binary sum: " + sum);
                    System.out.println("Decimal sum: " + decimalSum);
                    System.out.println("*************************************************");
                }

                if(choice == 2){                                            //subtraction
                    System.out.println("\n*************************************************");
                    System.out.println("Subtraction selected.");
                    System.out.print("Insert first number in decimal: ");
                    int num1 = scanner.nextInt();
                    System.out.print("Insert second number in decimal: ");
                    int num2 = scanner.nextInt();

                    // Determine the number of bits needed for representation
                    int maxAbsValue = Math.max(Math.abs(num1), Math.abs(num2));
                    int bit = Integer.toBinaryString(maxAbsValue).length() + 2; // Add extra bit for sign handling

                    // Convert numbers to binary
                    String binary1 = toBinary(num1, bit);
                    String binary2 = toBinary(num2, bit);

                    // Perform subtraction
                    int resultDecimal = num1 - num2;
                    String resultBinary = toBinary(resultDecimal, bit);

                    // Determine sign of the result
                    String signCheck = (resultDecimal >= 0) ? "positive" : "negative";

                    // Display results
                    System.out.println("\nResults:");
                    System.out.println(num1 + " in binary = " + binary1);
                    System.out.println(num2 + " in binary = " + binary2);
                    System.out.println();
                    System.out.println(binary1 + " - " + binary2 + " = " + resultBinary + " (" + signCheck + ")");
                    System.out.println();
                    System.out.println(resultBinary + " in decimal is " + resultDecimal);
                    System.out.println("*************************************************");
                }

                if(choice == 3){
                    int M = 0;   //multiplier
                    int Q = 0;   //multiplicand
                    int n = 0;   //number of bits
                    System.out.println("\n*************************************************");
                    System.out.println("Multiplication selected.");
                    System.out.print("Enter 1st value (in decimal): ");  //input values in decimal
                    int num1 = scanner.nextInt();
                    System.out.print("Enter 2nd value (in decimal): ");
                    int num2 = scanner.nextInt();

                    int temp = 0;

                    boolean negative = true;
                    if(num1>0 && num2<0){       //applying the negative value to Q
                        M=num1;
                        Q=num2;
                    }else if(num1<0 && num2>0){
                        M=num2;
                        Q=num1;
                    }else if(num1>0&&num2>0){
                        M=num1;
                        Q=num2;
                        negative = false;   //no negative value
                    }else{
                        M=num1*-1;
                        Q=num2*-1;
                        negative = false;
                    }

                    temp = (negative) ? Math.max(M,(Q*-1)):Math.max(M,Q);   //take the bigger bit value

                    while(temp>0){
                        temp/=2;
                        n++;        //setting the value of n (bits)
                    }n++;   //extra bit for signage

                    boothAlg(M,Q,n);
                }

                if(choice<0 || choice>3){
                    System.out.println("Out of range.");
                    continue;
                }

                scanner.nextLine(); //buffer
            }
        }catch(NumberFormatException e){
            System.out.println("Error: Choose between (1-3) or \"exit\"");
        }catch(Exception e) {
            System.out.println("Error: Invalid input. Please enter valid decimal numbers.");
        }
        scanner.close();
    }

    public static String decimalToBinary(int decimal) {
        if (decimal == 0) return "0";
        
        boolean isNegative = decimal < 0;
        decimal = Math.abs(decimal);
        
        // Always create 32-bit binary number
        char[] binary = new char[32];
        for (int i = 0; i < 32; i++) {
            binary[i] = '0'; //display 0 for 32 times
        }
        
        int index = 31;
        while (decimal > 0 && index >= 0) {
            binary[index] = (char)((decimal % 2) + '0'); //Converter to ASCII
            decimal = decimal / 2;
            index--;
        }
        
        String binaryStr = new String(binary);
        
        if (isNegative) {
           
            return findTwosComplement(binaryStr);
        }
        
        return binaryStr;
    }
    
    // Convert binary string to decimal
    public static int binaryToDecimal(String binary) {
        try {
            boolean isNegative = binary.charAt(0) == '1';
            
            if (isNegative) {
                // If negative, first find 2's complement
                String positiveNum = findTwosComplement(binary);
                int result = 0;
                int power = 0;
                
                for (int i = positiveNum.length() - 1; i >= 0; i--) {
                    if (positiveNum.charAt(i) == '1') {
                        result += Math.pow(2, power);
                    }
                    power++;
                }
                return -result;
            } else {
                int result = 0;
                int power = 0;
                
                for (int i = binary.length() - 1; i >= 0; i--) {
                    if (binary.charAt(i) == '1') {
                        result += Math.pow(2, power);
                    }
                    power++;
                }
                return result;
            }
        } catch (Exception e) {
            System.out.println("Invalid binary string: " + e.getMessage());
            return 0;
        }
    }
    
    // Add two binary strings
    public static String addBinary(String a, String b) {
        try {
            // Ensure both strings are 32 bits
            a = padZeros(a, 32);
            b = padZeros(b, 32);
            
            char[] result = new char[32];
            int carry = 0;
            
            // Add from right to left
            for (int i = 31; i >= 0; i--) {
                int sum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
                result[i] = (char)((sum % 2) + '0');
                carry = sum / 2;
            }
            
            return new String(result);
        } catch (Exception e) {
            System.out.println("Error in binary addition: " + e.getMessage());
            return "0";
        }
    }
    
    // Find 2's complement of a binary string (for negative numbers)
    public static String findTwosComplement(String binary) {
        // Ensure 32-bit binary
        binary = padZeros(binary, 32);
        
        // Find 1's complement
        char[] onesComplement = new char[32];
        for (int i = 0; i < 32; i++) {
            onesComplement[i] = (binary.charAt(i) == '0') ? '1' : '0';
        }
        
        // Add 1 to get 2's complement
        String onesComplementStr = new String(onesComplement);
        
        // Manual addition of 1 for two's complement
        char[] twosComplement = onesComplementStr.toCharArray();
        for (int i = 31; i >= 0; i--) {
            if (twosComplement[i] == '0') {
                twosComplement[i] = '1';
                break;
            }
            twosComplement[i] = '0';
        }
       
        return new String(twosComplement);
    }
    
    // Pad zeros to the left of a binary string
    private static String padZeros(String binary, int length) {
        if (binary.length() >= length) return binary;
        
        char[] padded = new char[length];
        int padding = length - binary.length();
        
        // Fill with zeros
        for (int i = 0; i < padding; i++) {
            padded[i] = '0';
        }
        
        // Copy original binary
        for (int i = 0; i < binary.length(); i++) {
            padded[i + padding] = binary.charAt(i);
        }
        
        return new String(padded);
    }

    private static String toBinary(int num, int bit) {
        int mask = (1 << bit) - 1;
        String binary = Integer.toBinaryString(num & mask); // Handles 2's complement representation
        return String.format("%" + bit + "s", binary).replace(' ', '0');
    }

    private static void boothAlg(int M, int Q, int n){          //booth's algorithm method
        int A = 0;  
        int bits = n;
        int Qm = 0;  //Q(-1)

        //display initial
        System.out.println("\nInitial values: A="+converter(A,bits)+", Q="+converter(Q,bits)+", Qm="+Qm+", n="+n+", M="+converter(M,bits));
        
        while(n>0){
                int Q0 = Q & 1;     //Q0 is rightmost value of Q

                if(Q0==1 && Qm==0){     //10    A <-- A-M
                    A -= M;
                    System.out.println("Substract by M: "+converter(A,bits));
                    System.out.println("Shift: A="+converter(A,bits)+", Q="+converter(Q,bits)+", Qm="+Qm+", n="+n);
                }else if(Q0==0 && Qm==1){   //01  A <-- A+M  
                    A += M;
                    System.out.println("Add M: "+converter(A,bits));
                    System.out.println("Shift: A="+converter(A,bits)+", Q="+converter(Q,bits)+", Qm="+Qm+", n="+n);
                }else{
                    System.out.println("Shift right.");
                }                
                
                //shift A to the left by bits for Q position, Q to the left by 1 bit for Qm position
                int AQQm = (A << bits+1) | (Q << 1) & ((1 << bits+1)-1) | Qm; //combination of A, Q and Q(-1)

                AQQm = AQQm >> 1; //arithmetic shift right

                A = AQQm >> bits+1; //extract A 
                Q = (AQQm >> 1) & ((1 << bits)-1);  //extract Q by eliminating Qm and A
                Qm = AQQm & 1;  //rightmost value

                n--;    //decreament
                
                System.out.println("Shift: A="+converter(A,bits)+", Q="+converter(Q,bits)+", Qm="+Qm+", n="+n);   //display every successful shift
            }

            int result = (A << bits) | Q;
            System.out.println("\nFinal value in binary: "+converter(result,(bits*2)));
            System.out.println("Final value in decimal: "+result);    //display final result
            System.out.println("*************************************************");
    }

    private static String converter(int a, int bits){  //to binary converter
        String binary = Integer.toBinaryString(a & ((1<<bits)-1));  //masking for 2's complement
        if(binary.length()>bits){
            binary = binary.substring(binary.length()-bits);
        }else{
            while(binary.length()<bits){
                binary = "0"+binary;
            }
        }
        return binary;
    }
}