import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRunner {

    public static Result getResult(String propertiesName) throws MissingResourceException {
        StringBuilder strResult = new StringBuilder();
        ResourceBundle rb = ResourceBundle.getBundle(propertiesName);
        Enumeration<String> keys = rb.getKeys();
        final String KEY_REG_EXP = "index(.*)";
        final String NUM_REG_EXP = "[1-9]\\d*";
        Pattern pattern = Pattern.compile(KEY_REG_EXP);
        Pattern pattern1 = Pattern.compile(NUM_REG_EXP);
        final int TAIL_INDEX = 1;
        final String VALUE = "value";
        int errorLines = 0;
        double result = 0;
        String key;
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            Matcher keyMatcher = pattern.matcher(key);
            if (keyMatcher.matches()) {
                String iStr = keyMatcher.group(TAIL_INDEX);
                String jStr = rb.getString(key).trim();
                Matcher iMatcher = pattern1.matcher(iStr);
                Pattern pattern2 = Pattern.compile(NUM_REG_EXP);
                Matcher jMatcher = pattern2.matcher(rb.getString(key));
                if (iMatcher.matches() && jMatcher.matches()) {
                    String valueIJ = VALUE + iStr + jStr;
                    try {
                        result += Double.parseDouble(rb.getString(valueIJ).trim());
                    } catch (MissingResourceException | NumberFormatException e) {
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

        return new Result(errorLines, result);

    }

    @Test
    public void testMainCase1() throws MissingResourceException {

        TestCase[] testCases = {
                new TestCase("in1", 3, 8.24),
                new TestCase("in2", 9, 30.242),
                new TestCase("in3", 0, 1.9)
        };
        Result[] results = {
                getResult("in1"),
                getResult("in2"),
                getResult("in3")
        };
        for (int i = 0; i < testCases.length; i++) {
            Assertions.assertEquals(testCases[i].getName(), "in" + (i + 1));
            Assertions.assertEquals(testCases[i].getError(), results[i].error);
            Assertions.assertEquals(testCases[i].getResult(), results[i].result, 0.000000000000002);
        }

    }

    @Test(expected = MissingResourceException.class)
    public void testWrongPropertiesName() throws MissingResourceException {
        Result result = getResult("resources.in4");
    }

    private class TestCase {
        private final String name;
        private final int error;
        private final double result;

        public TestCase() {
            this(null, 0, 0.00);
        }

        public TestCase(String name, int error, double result) {
            this.name = name;
            this.error = error;
            this.result = result;
        }

        public String getName() {
            return name;
        }

        public int getError() {
            return error;
        }

        public double getResult() {
            return result;
        }

        @Override
        public String toString() {
            return name + ";" + error + ";" + result;
        }
    }

    private static class Result {
        private final int error;
        private final double result;

        public Result() {
            this(0, 0.0);
        }

        public Result(int error, double result) {
            this.error = error;
            this.result = result;
        }

        public int getError() {
            return error;
        }

        public double getResult() {
            return result;
        }

        @Override
        public String toString() {
            return "sum = " + error + "\n" + "error_lines" + result;
        }
    }

}

