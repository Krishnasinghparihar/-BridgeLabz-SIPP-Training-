import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class LambdaSortExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ravi", "Anu", "Kiran", "Megha");

        Collections.sort(names, (a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("Sorted by length: " + names);

       
        Collections.sort(names, (a, b) -> b.compareTo(a));
        System.out.println("Sorted in reverse alphabetical order: " + names);
    }
}
