/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ico_project;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class ComputerArithemtic {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {            // Main method with user input
        MainMenu();
    }

    public static void MainMenu() {

        while (true) {

            System.out.println("\n=== Binary Operations Calculator ===");
            System.out.println("1. Quiz Program Execution");
            System.out.println("2. Calculator Manual");
            System.out.println("3. Addition");
            System.out.println("4. Subtraction");
            System.out.println("5. Multiplication");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("1")) {
                ProgramExecutionQuiz();

            } else if (choice.equalsIgnoreCase("2")) {
                Manual();

            } else if (choice.equalsIgnoreCase("3")) {
                Addition();
scanner.nextLine();
            } else if (choice.equalsIgnoreCase("4")) {
                Substraction();
scanner.nextLine();
            } else if (choice.equalsIgnoreCase("5")) {
                Multiplication();
scanner.nextLine();
            } else if (choice.equalsIgnoreCase("6")) {
                System.out.println("""
                                   ==========================================
                                    Goodbye!
                                    Thank you for using our application!
                                   ==========================================
                                   """);
                System.exit(0);
            } else {
                System.out.println("Invalid.1");

            }

        }

    }

    public static void ProgramExecutionQuiz() {

        //CPU component quiz coded by Amer Haqim
        int score = 0;

        System.out.println("Identify the missing components and their functions based on the diagram below:");

        // Display the diagram with placeholders
        System.out.println("\nDiagram:");
        System.out.println("  +----------------------------+");
        System.out.println("  |                            |");
        System.out.println("  |                            v");
        System.out.println("  |   +--------+        +--------+       +--------+             ");
        System.out.println("  |   |  PC    | ---->  |  ???   | ----> |        |                 ");
        System.out.println("  |   +--------+        +--------+       |  Main  |               ");
        System.out.println("  |                                      | Memory |            ");
        System.out.println("  |   +--------+        +--------+       |        |           ");
        System.out.println("  |   |  ???   | <----  |  MBR   | <---> |        |                 ");
        System.out.println("  |   +--------+        +--------+       +--------+                   ");
        System.out.println("  |       |                    ^                                 ");
        System.out.println("  |       V                    |                                 ");
        System.out.println("  |  +----------------+        |                                 ");
        System.out.println("  +--| Execution Unit |--------+                                 ");
        System.out.println("     +----------------+                                          ");
        System.out.println("        |           |                                            ");
        System.out.println("        v           v");
        System.out.println("     +--------+  +--------+                                     ");
        System.out.println("     | I/O AR |  | I/O BR |      ");
        System.out.println("     +--------+  +--------+       ");
        System.out.println("         |         ^          ");
        System.out.println("         |         |  ");
        System.out.println("         v         v             ");
        System.out.println("     +-------------------+");
        System.out.println("     |    I/O Module     |");
        System.out.println("     +-------------------+");

        System.out.println("\nFill in the missing components or their functions:");

        // Question 1: Mystery Component 1
        System.out.println("--------------------------------------------------------------");
        System.out.println("1. What is the name of the component labeled '???' that connects PC to Main Memory? ");
        String answer1 = scanner.nextLine().toLowerCase();
        if (answer1.contains("mar") || answer1.contains("memory address register")) {
            System.out.println("Correct. It is the Memory Address Register (MAR).");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is Memory Address Register (MAR).");
        }

        // Question 2: Function of the PC
        System.out.println("--------------------------------------------------------------");
        System.out.println("\n2. What is the function of the Program Counter (PC)?");
        System.out.println("   a) It stores the data fetched from memory.");
        System.out.println("   b) It holds the address of the next instruction.");
        System.out.println("   c) It decodes and executes the instructions.");
        while (true) {
            System.out.print("   Enter your choice (a, b, c): ");
            String answer2 = scanner.nextLine().toLowerCase();
            if (answer2.equals("b")) {
                System.out.println("Correct.");
                score++;
                break;
            } else if (answer2.equals("a") || answer2.equals("c")) {
                System.out.println("Incorrect. The correct answer is b) ");
                break;
            } else {
                System.out.println("Invalid option, please enter (a/b/c) only");
            }
        }
        // Question 3: Mystery Component 2
        System.out.println("--------------------------------------------------------------");
        System.out.println("\n3. What is the name of the component labeled '???' that connects MBR to Execution Unit? ");
        String answer3 = scanner.nextLine().toLowerCase();
        if (answer3.contains("ir") || answer3.contains("instruction register")) {
            System.out.println("Correct! It is the Instruction Register (IR).");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer is Instruction Register (IR).");
        }

        // Question 4: Function of the MBR
        System.out.println("--------------------------------------------------------------");
        System.out.println("\n4. What is the function of the Memory Buffer Register (MBR)?");
        System.out.println("   a) It holds the data read from or written to memory.");
        System.out.println("   b) It decodes the instructions.");
        System.out.println("   c) It transfers the address of the next instruction.");
        while (true) {
            System.out.print("   Enter your choice (a, b, c): ");
            String answer4 = scanner.nextLine().toLowerCase();
            if (answer4.equals("a")) {
                System.out.println("Correct.");
                score++;
                break;
            } else if (answer4.equals("b") || answer4.equals("c")) {
                System.out.println("Incorrect. The correct answer is b) ");
                break;
            } else {
                System.out.println("Invalid option, please enter (a/b/c) only");
            }
        }

        // Question 5: Function of the Execution Unit
        System.out.println("--------------------------------------------------------------");
        System.out.println("\n5. What is the function of the Execution Unit?");
        System.out.println("   a) It stores the data to be fetched.");
        System.out.println("   b) It performs operations and calculations");
        System.out.println("   c) It transfers data between memory and CPU.");

        while (true) {
            System.out.print("   Enter your choice (a, b, c): ");
            String answer5 = scanner.nextLine().toLowerCase();
            if (answer5.equals("b")) {
                System.out.println("Correct.");
                score++;
                break;
            } else if (answer5.equals("a") || answer5.equals("c")) {
                System.out.println("Incorrect. The correct answer is b) ");
                break;
            } else {
                System.out.println("Invalid option, please enter (a/b/c) only");
            }
        }
System.out.println("--------------------------------------------------------------");
        // Final Score
        System.out.println("\nYour final score: " + score + "/5");
System.out.println("--------------------------------------------------------------");
    }

    public static void Manual() {

        System.out.println("=== Addition Manual ===");
        System.out.println("""
                                       1. User will input two number decimal
                                       2. The program will convert it into binary number in 32 bit
                                       3. If the number that input is negative, the program will convert to two complement first by having negation process
                                       4. The two binary number will by manually
                                       5. After addition process, the result of binary will appear 
                                       6. The result will convert into decimal and the result of decimal will appear 
                                       7. The limit of result is 2,147,483,647""");
        System.out.println("\n=== Subtraction Manual ===");
        System.out.println("""
                                       1. User will input two number decimal
                                       2. The program will convert it into binary number in 32 bit
                                       3. If the number that input is negative, the program will convert to two complement first by having negation process
                                       4. The two binary number will by manually
                                       5. After addition process, the result of binary will appear 
                                       6. The result will convert into decimal and the result of decimal will appear 
                                       7. The limit of result is 2,147,483,647""");
        System.out.println("\n=== Multiplication Manual ===");
        System.out.println("""
                                       1. User will input two number decimal
                                       2. The program will convert it into binary number in 32 bit
                                       3. If the number that input is negative, the program will convert to two complement first by having negation process
                                       4. The two binary number will by manually
                                       5. After addition process, the result of binary will appear 
                                       6. The result will convert into decimal and the result of decimal will appear 
                                       7. The limit of result is 2,147,483,647""");

    }

    public static void Addition() {
        //addition
        System.out.println("\n==============================================================");
        System.out.println("                    ADDITION SELECTED");
        System.out.println("==============================================================");
        int num1;
        int num2;
        while (true) {
            try {
                System.out.println("--------------------------------------------------------------");
                System.out.print("Enter first number (decimal): ");
                num1 = scanner.nextInt();
                System.out.print("Enter second number (decimal): ");
                num2 = scanner.nextInt();
                System.out.println("--------------------------------------------------------------");
                break;
            } catch (InputMismatchException e) {
                System.out.println("*******************************************");
                System.out.println("Invalid Decimal Number. Please Enter Again");
                System.out.println("*******************************************");
                scanner.nextLine();
            }
        }

        // Determine the number of bits needed for representation
        int maxAbsValue = Math.max(Math.abs(num1), Math.abs(num2));
        int bit = Integer.toBinaryString(maxAbsValue).length() + 2; // Add extra bit for sign handling

        // Convert numbers to binary
        String binary1 = toBinary(num1, bit);
        String binary2 = toBinary(num2, bit);

        // Perform addition
        int resultDecimal = num1 + num2;
        String resultBinary = toBinary(resultDecimal, bit);

        // Determine sign of the result
        String signCheck = (resultDecimal >= 0) ? "positive" : "negative";

        // Display results
        System.out.println("\nResults:");
        System.out.println(num1 + " in binary = " + binary1);
        System.out.println(num2 + " in binary = " + binary2);
        System.out.println();
        System.out.println(num1 + " + " + num2);
        System.out.println(binary1 + " + " + binary2 + " = " + resultBinary + " (" + signCheck + ")");
        System.out.println();
        System.out.println(resultBinary + " in decimal is " + resultDecimal);
        System.out.println("\n==============================================================");
    }

    public static void Substraction() {
        //subtraction
   System.out.println("\n==============================================================");
        System.out.println("                    SUBSTRACTION SELECTED");
   System.out.println("==============================================================");
        int num1;
        int num2;
        while (true) {
            try {
                System.out.println("--------------------------------------------------------------");
                System.out.print("Enter first number (decimal): ");
                num1 = scanner.nextInt();

                System.out.print("Enter second number (decimal): ");
                num2 = scanner.nextInt();
System.out.println("--------------------------------------------------------------");
                break;
            } catch (InputMismatchException e) {
                     System.out.println("*******************************************");
                System.out.println("Invalid Decimal Number. Please Enter Again");
                System.out.println("*******************************************");
                scanner.nextLine();
            }

        }
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
      System.out.println("\n==============================================================");

    }

    public static void Multiplication() {
        int M = 0;   //multiplier
        int Q = 0;   //multiplicand
        int n = 0;   //number of bits
      System.out.println("\n==============================================================");
        System.out.println("                    MULTIPLICATION SELECTED");
        System.out.println("==============================================================");
        int num1;
        int num2;
        while (true) {
            try {
                System.out.println("--------------------------------------------------------------");
                System.out.print("Enter first number (decimal): ");
                num1 = scanner.nextInt();

                System.out.print("Enter second number (decimal): ");
                num2 = scanner.nextInt();
System.out.println("--------------------------------------------------------------");
                break;
            } catch (InputMismatchException e) {
                System.out.println("*******************************************");
                System.out.println("Invalid Decimal Number. Please Enter Again");
                System.out.println("*******************************************");
                scanner.nextLine();
            }

        }

        int temp;

        boolean negative = true;
        if (num1 > 0 && num2 < 0) {       //applying the negative value to Q
            M = num1;
            Q = num2;
        } else if (num1 < 0 && num2 > 0) {
            M = num2;
            Q = num1;
        } else if (num1 > 0 && num2 > 0) {
            M = num1;
            Q = num2;
            negative = false;   //no negative value
        } else {
            M = num1 * -1;
            Q = num2 * -1;
            negative = false;
        }

        temp = (negative) ? Math.max(M, (Q * -1)) : Math.max(M, Q);   //take the bigger bit value

        while (temp > 0) {
            temp /= 2;
            n++;        //setting the value of n (bits)
        }
        n++;   //extra bit for signage

        boothAlg(M, Q, n);

    }

    //Addtion Method Start
//    private static String toBinary(int num, int bit) {
//        int mask = (1 << bit) - 1;
//        String binary = Integer.toBinaryString(num & mask); // Handles 2's complement representation
//        return String.format("%" + bit + "s", binary).replace(' ', '0');
//    }
    //Addition Method Stop

    //Subtraction Method Start
    private static String toBinary(int num, int bit) {
        int mask = (1 << bit) - 1;
        String binary = Integer.toBinaryString(num & mask); // Handles 2's complement representation
        return String.format("%" + bit + "s", binary).replace(' ', '0');
    }
    //Subtraction Method Stop

    //Multiplication Method Start
    private static void boothAlg(int M, int Q, int n) {          //booth's algorithm method
        int A = 0;
        int bits = n;
        int Qm = 0;  //Q(-1)

        //display initial
        System.out.println("\nInitial values: A=" + converter(A, bits) + ", Q=" + converter(Q, bits) + ", Qm=" + Qm + ", n=" + n + ", M=" + converter(M, bits));

        while (n > 0) {
            int Q0 = Q & 1;     //Q0 is rightmost value of Q

            if (Q0 == 1 && Qm == 0) {     //10    A <-- A-M
                A -= M;
                System.out.println("Substract by M: " + converter(A, bits));
                System.out.println("Shift: A=" + converter(A, bits) + ", Q=" + converter(Q, bits) + ", Qm=" + Qm + ", n=" + n);
            } else if (Q0 == 0 && Qm == 1) {   //01  A <-- A+M  
                A += M;
                System.out.println("Add M: " + converter(A, bits));
                System.out.println("Shift: A=" + converter(A, bits) + ", Q=" + converter(Q, bits) + ", Qm=" + Qm + ", n=" + n);
            } else {
                System.out.println("Shift right.");
            }

            //shift A to the left by bits for Q position, Q to the left by 1 bit for Qm position
            int AQQm = (A << bits + 1) | (Q << 1) & ((1 << bits + 1) - 1) | Qm; //combination of A, Q and Q(-1)

            AQQm = AQQm >> 1; //arithmetic shift right

            A = AQQm >> bits + 1; //extract A 
            Q = (AQQm >> 1) & ((1 << bits) - 1);  //extract Q by eliminating Qm and A
            Qm = AQQm & 1;  //rightmost value

            n--;    //decreament

            System.out.println("Shift: A=" + converter(A, bits) + ", Q=" + converter(Q, bits) + ", Qm=" + Qm + ", n=" + n);   //display every successful shift
        }

        int result = (A << bits) | Q;
        System.out.println("\nFinal value in binary: " + converter(result, (bits * 2)));
        System.out.println("Final value in decimal: " + result);    //display final result
        System.out.println("\n============================================================");

    }

    private static String converter(int a, int bits) {  //to binary converter
        String binary = Integer.toBinaryString(a & ((1 << bits) - 1));  //masking for 2's complement
        if (binary.length() > bits) {
            binary = binary.substring(binary.length() - bits);
        } else {
            while (binary.length() < bits) {
                binary = "0" + binary;
            }
        }
        return binary;
    }
    //Multiplication Method Stop

}
