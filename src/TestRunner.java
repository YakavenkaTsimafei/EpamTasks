import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestRunner {
    final static String BEFORE_SIGN = " ";
    final static String AFTER_SIGN = " ";
    final static String PLUS = BEFORE_SIGN + "+" + AFTER_SIGN;
    final static String MINUS = BEFORE_SIGN + "-" + AFTER_SIGN;
    final static String DELIMITER = ";";
    final static String RESULT_HEAD = "result(";
    final static String RESULT_TAIL = ") = ";

    private static int getResult(String csvName, StringBuilder strResult) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new FileReader("src\\by\\epam\\lab\\" + csvName))) {
            double result = 0;
            int errorLines = 0;
            while (sc.hasNext()) {
                String[] number = sc.nextLine().split(DELIMITER);
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
            if (strResult.length() > 0) {
                final int SING_MINUS_LENGTH = MINUS.length();
                final int SING_PLUS_LENGTH = PLUS.length();
                final char CHAR_MINUS = '-';
                if (strResult.substring(0, SING_MINUS_LENGTH).equals(MINUS)) {
                    strResult.replace(0, SING_MINUS_LENGTH, String.valueOf(CHAR_MINUS));
                }
                if (strResult.substring(0, SING_PLUS_LENGTH).equals(PLUS)) {
                    strResult.delete(0, SING_PLUS_LENGTH);
                }
            }
            strResult.insert(0, RESULT_HEAD).append(RESULT_TAIL).append(result);
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
        String expectedIn1 = RESULT_HEAD + "5.2" + MINUS + "3.14" + PLUS + "0.0" + RESULT_TAIL + "2.06";
        assertEquals(expectedIn1, result.toString());
    }

    @Test
    public void testMainIn1() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in1.txt", result);
        assertEquals(0, errorLines);
        String expectedIn1 = RESULT_HEAD + "-3.1" + MINUS + "1.0" + RESULT_TAIL + "-4.1";
        assertEquals(expectedIn1, result.toString());
    }

    @Test
    public void testMainIn2() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in2.txt", result);
        assertEquals(0, errorLines);
        String expectedIn2 = RESULT_HEAD + "0.75" + RESULT_TAIL + "0.75";
        assertEquals(expectedIn2, result.toString());
    }

    @Test
    public void testMainIn3() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in3.txt", result);
        assertEquals(0, errorLines);
        String expectedIn3 = RESULT_HEAD + "0.0" + RESULT_TAIL + "0.0";
        assertEquals(expectedIn3, result.toString());
    }

    @Test
    public void testMainIn4() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in4.txt", result);
        assertEquals(1, errorLines);
        String expectedIn3 = RESULT_HEAD + RESULT_TAIL + "0.0";
        assertEquals(expectedIn3, result.toString());
    }

    @Test(expected = FileNotFoundException.class)
    public void testWrongCsvName() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(("")));
        sc.close();
    }
}

