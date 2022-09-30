import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRunner {

    public static Result getResult(String propertiesName) throws MissingResourceException {
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
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
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
        return new Result(errorLines, result);
    }

    @Test
    public void testMainCase1() throws MissingResourceException {

        TestCase[] testCases = {
                new TestCase(new Result(3, 8.24), "fileWithInformation1"),
                new TestCase(new Result(9, 30.242), "fileWithInformation2"),
                new TestCase(new Result(0, 1.9), "fileWithInformation3")
        };
        for (TestCase testCase : testCases) {
            Assertions.assertEquals(testCase.getError(), getResult(testCase.getFileName()).getError());
            Assertions.assertEquals(testCase.getResult(), getResult(testCase.getFileName()).getResult(), 0.000000000000002);
        }

    }

    @Test(expected = MissingResourceException.class)
    public void testWrongPropertiesName() throws MissingResourceException {
        Result result = getResult("resources.in4");
    }

    private class TestCase {
        private final Result result;
        private final String fileName;

        public TestCase() {
            this(new Result(0, 0.0), null);
        }

        public TestCase(Result result, String filename) {
            this.result = result;
            this.fileName = filename;
        }

        public int getError() {
            return result.getError();
        }

        public double getResult() {
            return result.getResult();
        }

        public String getFileName() {
            return fileName;
        }

    }

    private static class Result {
        private static final String SUM_EQUALS = "sum = ";
        private static final String ERROR_LINES_EQUAL = "error_lines = ";
        private static final String NEXT_LINE = "\n";
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
            return SUM_EQUALS + error + NEXT_LINE + ERROR_LINES_EQUAL + result;
        }
    }

}

