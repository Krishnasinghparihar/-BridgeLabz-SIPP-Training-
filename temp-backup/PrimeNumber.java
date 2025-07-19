package workshop;
import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number ");
        int number = sc.nextInt();
        sc.close();

        if (isPrime(number)) {
            System.out.println( "is a prime number");
        } else {
            System.out.println(" is not a prime number");
        }
    }

    public static boolean isPrime(int num) {
       
        if (num <= 1) {
            return false;
        }
 
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; 
            }
        }

        return true; 
    }
}





