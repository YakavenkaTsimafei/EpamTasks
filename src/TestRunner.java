import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TestRunner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src\\in.txt"))) {

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
