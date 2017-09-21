/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author peraa0837
 */
public class Recursion {
    
    
    private static String letters[] = new String[] {"A", "B", "C", "D", "E", "F"};

    //QUESTION 1
    public int digitalSum(int n) {
        //base case if n = 0

        if (n == 0) {
            return 0;
        } else {
            //if n != 0, find the remainder after dividing by 10, add r to sum
            //then return digitalSum of n / 10
            int r = n % 10;


            return r + digitalSum(n / 10);

        }
    }
    //QUESTION 2

    public int digitalRoot(int n) {
        int dsum = digitalSum(n);
        //base case of n = 0
        if (dsum < 10) {
            return dsum;
        } else {
            //uses previous digitalSum method to find the digitalSum of a digitalSum
            // return digitalSum();

            return digitalRoot(dsum);
        }
    }
    //QUESTION 3

    public int triangle(int n) {
        //get rid of negative
        if (n <= 0) {
            return n;
        }
        //base case if n = 1 return 1
        if (n == 1) {
            return 1;
        } else {
            //if n > 1 add triangle(n - 1) to n
            return (n + triangle(n - 1));

        }
    }

    //QUESTION 4
    public int hailstone(int n) {
        //base case of n = 1
        if (n == 1) {
            System.out.println(n);
            return 1;
        } else {
            //if odd, multiply number by 3 and add 1 then call hailstone on new number
            System.out.println(n);
            if (n % 2 == 1) {
                n = 3 * n + 1;
                return hailstone(n);
            } else {
                //if even, divid number by 2 and call hailstone on new number
                n = n / 2;
                return hailstone(n);
            }

        }
    }

    //QUESTION 5
    public String binaryConvert(int n) {

        //convert n to string
        String a = "" + n;

        //n cannot be a negative integer
        if (n <= 0) {
            System.out.println("Negatives and 0 are not allowed!");
        }

        //base case of n = 1
        if (n == 1) {
            return a;
        } else {
            //if n modulus 2 = 0, add a zero to the binary number
            //else, add a one to the bianry number
            if (n % 2 == 0) {
                return binaryConvert(n / 2) + "0";
            } else {
                return binaryConvert(n / 2) + "1";


            }
        }
    }

    //QUESTION 6
    public static String convert(int n, int b) {
//create quotient and remainder variables
        int r = n % b;
        int q = n / b;
        
        //if the remainder is greater than 10 but less than 15
        //replace a 2 digit number with a letter
       if(r >= 10){
           return convert(q, b) + letters[r - 10];
       }else if(r > 15){
           return Integer.toString(n);
       }
        //base case of n = 0
        if (q == 0) {
            //convert r to string and return it
            return Integer.toString(r);
        } else {
            //take quotient and repeat process
            return convert(q, b) + Integer.toString(r);
        }
    }
    
    //QUESTION 7
    
    public boolean palindrome(String y){
        //base case of the length of the string = 0 or 1
        if(y.length() == 0 || y.length() == 1){
            return true;
            //if not 1 or 0 long, determine if the first and last character are equal
        }else if(y.charAt(0) == y.charAt(y.length() - 1)){
            //if so, return palindrome of y without first or last digit, narrowing to 1 or 0
            return palindrome(y.substring(1, y.length() - 1));
            //if neither conditions are met, it is not a palindrome
        }else{
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Recursion test = new Recursion();

        System.out.println("QUESTION 1: ");
        int answer = test.digitalSum(125);
        System.out.println("125 = " + answer);
        int answer2 = test.digitalSum(253);
        System.out.println("253 = " + answer2);
        int answer3 = test.digitalSum(1572);
        System.out.println("1572 = " + answer3);

        System.out.println("--------------------------");
        System.out.println("QUESTION 2: ");

        int answer4 = test.digitalRoot(2019);
        System.out.println("2019 = " + answer4);
        int answer5 = test.digitalRoot(75483);
        System.out.println("75483 = " + answer5);
        int answer6 = test.digitalRoot(12334);
        System.out.println("12334 = " + answer6);

        System.out.println("-------------------------");
        System.out.println("QUESTION 3: ");

        int answer7 = test.triangle(3);
        System.out.println("3 = " + answer7);
        int answer8 = test.triangle(2);
        System.out.println("2 = " + answer8);
        int answer9 = test.triangle(7);
        System.out.println("7 = " + answer9);

        System.out.println("---------------------------");
        System.out.println("QUESTION 4: ");

        System.out.println("When n = 12");
        int answer10 = test.hailstone(12);
        System.out.println("When n = 5");
        int answer11 = test.hailstone(5);
        System.out.println("When n = 7");
        int answer12 = test.hailstone(7);

        System.out.println("-----------------------------");
        System.out.println("QUESTION 5: ");

        String answer13 = test.binaryConvert(156);
        System.out.println("n = 156: " + answer13);
        String answer14 = test.binaryConvert(224);
        System.out.println("n = 224: " + answer14);
        String answer15 = test.binaryConvert(67);
        System.out.println("n = 67: " + answer15);

        System.out.println("------------------------------");
        System.out.println("QUESTION 6: ");

        System.out.println("for n = 1000 and b = 16: ");
        String answer16 = test.convert(1000, 16);
        System.out.println(answer16);
        System.out.println("for n = 1000 and b = 8: ");
        String answer17 = test.convert(1000, 8);
        System.out.println(answer17);
        System.out.println("for n = 1000 and b = 4: ");
        String answer18 = test.convert(1000, 4);
        System.out.println(answer18);
        
        System.out.println("--------------------------------");
        System.out.println("QUESTION 7: ");
        
        boolean answer19 = test.palindrome(Integer.toString(12321));
        System.out.println("For y = 12321: " + answer19);
        boolean answer20 = test.palindrome(Integer.toString(1234));
        System.out.println("For y = 1234: " + answer20);
        boolean answer21 = test.palindrome("racecar");
        System.out.println("For y = racecar: " + answer21);
    }
}
