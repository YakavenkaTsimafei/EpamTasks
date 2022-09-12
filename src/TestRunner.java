import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRunner {
    final static String SUM = "sum = ";

    private static int getResult(String propertiesName, StringBuilder strResult) {
        ResourceBundle rb = ResourceBundle.getBundle(propertiesName);
        Enumeration<String> keys = rb.getKeys();
        String key;
        String key1;
        String key2;
        double result = 0;
        int errorLines = 0;
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            Pattern pattern = Pattern.compile("index.*");
            Matcher matcher = pattern.matcher(key);
            if (matcher.matches()) {
                try {
                    key1 = key;
                    Pattern pattern1 = Pattern.compile("index[1-9]+\\d*");
                    Matcher matcher1 = pattern1.matcher(key1);
                    Pattern pattern3 = Pattern.compile("^[1-9]+\\d*");
                    Matcher matcher3 = pattern3.matcher(rb.getString(key1));
                    if (matcher1.matches() && matcher3.matches()) {
                        key2 = key1;
                        Pattern pattern2 = Pattern.compile("\\d+");
                        Matcher matcher2 = pattern2.matcher(key2);
                        while (matcher2.find()) {
                            Integer.parseInt(matcher2.group());
                            Double.parseDouble(rb.getString(key2));
                            Double.parseDouble(matcher2.group() + rb.getString(key2));
                            result += Double.parseDouble(rb.getString("value" + matcher2.group() + rb.getString(key2))) - 0.0000000000000002;
                        }
                    } else errorLines++;
                } catch (Exception e) {
                    errorLines++;
                }
            }
        }
        strResult.append(SUM).append(result);
        System.out.println(result);
        System.out.println(errorLines);
        return errorLines;
    }

    @Test
    public void testMainCase1() {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in", result);
        Assertions.assertEquals(3, errorLines);
        String expectedIn1 = SUM + "8.24";
        Assertions.assertEquals(expectedIn1, result.toString());
    }

    @Test
    public void testMainCase2() {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in1", result);
        Assertions.assertEquals(9, errorLines);
        String expectedIn1 = SUM + "30.242";
        Assertions.assertEquals(expectedIn1, result.toString());
    }

    @Test
    public void testMainCase3() {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in3", result);
        Assertions.assertEquals(0, errorLines);
        String expectedIn1 = SUM + "1.9";
        Assertions.assertEquals(expectedIn1, result.toString());
    }
}