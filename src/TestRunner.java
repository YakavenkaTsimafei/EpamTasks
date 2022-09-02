import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestRunner {
    private static int getResult(String csvName, StringBuilder strResult) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new FileReader("src\\by\\epam\\lab\\" + csvName))) {
            final String BEFORE_SIGN = " ";
            final String AFTER_SIGN = " ";
            final String PLUS = BEFORE_SIGN + "+" + AFTER_SIGN;
            final String MINUS = BEFORE_SIGN + "-" + AFTER_SIGN;
            final String DELIMITER = ";";
            final String RESULT_HEAD = "result(";
            final String RESULT_TAIL = ") = ";
            double result = 0;
            int errorLines = 0;
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] number = line.split( DELIMITER);
                try {
                    result += Double.parseDouble(number[Integer.parseInt(number[0])]);
                    if (Double.parseDouble(number[Integer.parseInt(number[0])]) >= 0) {
                        strResult.append(PLUS).append(Double.parseDouble(number[Integer.parseInt(number[0])]));
                    } else {
                        strResult.append(MINUS).append(Double.parseDouble(number[Integer.parseInt(number[0])]) * -1);
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    errorLines++;
                }

            }
            strResult.insert(0, RESULT_HEAD).append(RESULT_TAIL).append(result);
            if (strResult.substring(7, 10).equals(MINUS)) {
                strResult.replace(7, 13, String.valueOf(Double.parseDouble(strResult.substring(9, 13)) * -1));
            } else {
                strResult.delete(7, 10);
            }
            System.out.println(strResult);
            System.out.println("error-lines = " + errorLines);
            return errorLines;

        }
    }

    @Test
    public void testMainIn() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in.txt", result);
        assertEquals(3, errorLines);
        String expectedIn1 = "result(5.2 - 3.14 + 0.0) = 2.06";
        assertEquals(expectedIn1, result.toString());
    }

    @Test
    public void testMainIn1() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in1.txt", result);
        assertEquals(0, errorLines);
        String expectedIn1 = "result(-3.1 - 1.0) = -4.1";
        assertEquals(expectedIn1, result.toString());
    }

    @Test
    public void testMainIn2() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in2.txt", result);
        assertEquals(0, errorLines);
        String expectedIn2 = "result(0.75) = 0.75";
        assertEquals(expectedIn2, result.toString());
    }

    @Test
    public void testMainIn3() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in3.txt", result);
        assertEquals(0, errorLines);
        String expectedIn3 = "result(0.0) = 0.0";
        assertEquals(expectedIn3, result.toString());
    }

    @Test(expected = FileNotFoundException.class)
    public void testWrongCsvName() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(("")));
        sc.close();
    }
}

