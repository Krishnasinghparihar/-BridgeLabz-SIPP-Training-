package Day4_Methods;
import java.util.*;
public class numbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


     
        System.out.print("Enter an integer number: ");
        int number = sc.nextInt();

        
        int result = checkNumber(number);

      
        if (result == 1) {
            System.out.println("The number is Positive.");
        } else if (result == -1) {
            System.out.println("The number is Negative.");
        } else {
            System.out.println("The number is Zero.");
        }

        sc.close();
    }

    private static int checkNumber(int number) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkNumber'");
    }







    }
    

