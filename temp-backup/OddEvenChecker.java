import java.util.Scanner;

public class OddEvenChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Invalid input! Please enter a natural number (greater than 0).");
        } else {
            
            System.out.println("Odd and Even numbers from 1 to " + number + ":");
            for (int i = 1; i <= number; i++) {
                
                if (i % 2 == 0) {
                    System.out.println(i + " is Even");
                } else {
                    System.out.println(i + " is Odd");
                }
            }
        }

        sc.close();
    }
}