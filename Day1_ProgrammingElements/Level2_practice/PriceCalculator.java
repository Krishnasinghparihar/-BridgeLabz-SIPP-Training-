package Day1_ProgrammingElements.Level2_practice;

import java.util.Scanner;

public class PriceCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double unitPrice;
        int quantity;

        System.out.print("Enter the unit price of the item: ");
        unitPrice = input.nextDouble();

        System.out.print("Enter the quantity to be bought: ");
        quantity = input.nextInt();

        double totalPrice = unitPrice * quantity;

        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and unit price is INR " + unitPrice);

        input.close();
    }
}
