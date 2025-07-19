package Day1_ProgrammingElements.Level1_practice;

public class KmToMiles {
    public static void main(String[] args) {
        // Distance in kilometers
        double kilometers = 10.8;

        // Conversion factor: 1 kilometer = 1.6 miles
        double conversionFactor = 1.6;

        // Convert kilometers to miles
        double miles = kilometers * conversionFactor;

        // Display the result
        System.out.println("The distance " + kilometers + " km in miles is " + miles);
    }
}
