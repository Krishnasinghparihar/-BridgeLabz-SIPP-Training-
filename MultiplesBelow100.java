
import java.util.*;
public class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter a positive number less than 100: ");
        int number = sc.nextInt();

        
        if (number <= 0 || number >= 100) {
            System.out.println("Invalid input! Please enter a number > 0 and < 100.");
        } else {
            System.out.println("Multiples of " + number + " below 100 are:");

            
            int multiple = number;

            while (multiple < 100) {
          
                System.out.println(multiple);

                
                multiple += number;
            }
        }

        sc.close();
    }
}

 
    

