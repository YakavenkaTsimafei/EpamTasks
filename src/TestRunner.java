import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestRunner {
    private static int getResult(String csvName, StringBuilder strResult) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new FileReader("src\\by\\epam\\lab\\" + csvName))) {
            final String PLUS = " + ";
            final String MINUS = " - ";
            final String EQUALLY = " = ";
            double result = 0;
            int errorLines = 0;
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] number = line.split(";");
                if (isNumeric(number)) {
                    result += Double.parseDouble(number[Integer.parseInt(number[0])]);
                    if (Double.parseDouble(number[Integer.parseInt(number[0])]) >= 0) {
                        strResult.append(PLUS).append(Double.parseDouble(number[Integer.parseInt(number[0])]));
                    } else strResult.append(MINUS).append(Double.parseDouble(number[Integer.parseInt(number[0])]) * -1);
                } else {
                    errorLines++;
                }

            }
            strResult.append(EQUALLY).append(result);
            if (strResult.substring(0, 3).equals(MINUS)) {
                strResult.replace(0, 6, String.valueOf(Double.parseDouble(strResult.substring(2, 6)) * -1));
            } else strResult.delete(0, 3);
            return errorLines;
        }
    }

    private static boolean isNumeric(String[] number) {
        try {
            Double.parseDouble(number[Integer.parseInt(number[0])]);
            return true;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    @Test
    public void testMainIn() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in.txt", result);
        assertEquals(3, errorLines);
        String expectedIn1 = "5.2 - 3.14 + 0.0 = 2.06";
        assertEquals(expectedIn1, result.toString());
    }

    @Test
    public void testMainIn1() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in1.txt", result);
        assertEquals(0, errorLines);
        String expectedIn1 = "-3.1 - 1.0 = -4.1";
        assertEquals(expectedIn1, result.toString());
    }

    @Test
    public void testMainIn2() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in2.txt", result);
        assertEquals(0, errorLines);
        String expectedIn2 = "0.75 = 0.75";
        assertEquals(expectedIn2, result.toString());
    }

    @Test
    public void testMainIn3() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in3.txt", result);
        assertEquals(0, errorLines);
        String expectedIn3 = "0.0 = 0.0";
        assertEquals(expectedIn3, result.toString());
    }

    @Test(expected = FileNotFoundException.class)
    public void testWrongCsvName() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("", result);
        assertEquals(0,errorLines);
        String expected = "0.0 = 0.0";
        assertEquals(expected,result.toString());

    }


}

