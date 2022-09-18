import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRunner {
    final static String SUM = "sum = ";

    public static int getResult(String propertiesName, StringBuilder strResult) throws MissingResourceException {
        ResourceBundle rb = ResourceBundle.getBundle(propertiesName);
        Enumeration<String> keys = rb.getKeys();
        final String KEY_REG_EXP = "index(.*)";
        final String NUM_REG_EXP = "[1-9]\\d*";
        final int TAIL_INDEX = 1;
        final String VALUE = "value";
        String key;
        int errorLines = 0;
        double result = 0;
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            Pattern pattern = Pattern.compile(KEY_REG_EXP);
            Matcher keyMatcher = pattern.matcher(key);
            if (keyMatcher.matches()) {
                String iStr = keyMatcher.group(TAIL_INDEX);
                String jStr = rb.getString(key).trim();
                Pattern pattern1 = Pattern.compile(NUM_REG_EXP);
                Matcher iMatcher = pattern1.matcher(iStr);
                Pattern pattern3 = Pattern.compile(NUM_REG_EXP);
                Matcher jMatcher = pattern3.matcher(rb.getString(key));
                if (iMatcher.matches() && jMatcher.matches()) {
                    String valueIJ = VALUE + iStr + jStr;
                    try {
                        result += Double.parseDouble(rb.getString(valueIJ));
                    } catch (Exception e) {
                        errorLines++;
                    }
                } else {
                    errorLines++;
                }
            }
        }

        strResult.append(result);
        System.out.println(result);
        System.out.println(errorLines);
        return errorLines;
    }

    @Test
    public void testMainCase1() throws MissingResourceException {

        class TestCase {
            private final String name;
            private final StringBuilder result;

            public TestCase(String name, StringBuilder result) {
                this.name = name;
                this.result = result;
            }

            public int getErrorLines() {
                return getResult(name, result);
            }

            public double getRes() {
                return Double.parseDouble(result.toString());
            }

        }

        TestCase[] testCases = {
                new TestCase("in", new StringBuilder()),
                new TestCase("in1", new StringBuilder()),
                new TestCase("in2", new StringBuilder())};

        String[] filenames = {
                "in1", "in2", "in3"
        };
        int[] expectedErrors = {
                3, 9, 0
        };
        double[] expectedResults = {
                8.24, 30.242, 1.9
        };

        for (int i = 0; i < filenames.length; i++) {
            Assertions.assertEquals(testCases[i].getErrorLines(), expectedErrors[i]);
            Assertions.assertEquals(testCases[i].getRes(), expectedResults[i], 0.000000000000002);

        }
    }

    @Test(expected = MissingResourceException.class)
    public void testWrongPropertiesName() throws MissingResourceException {
        int errorLines = getResult("resources.in4", new StringBuilder());
    }
}