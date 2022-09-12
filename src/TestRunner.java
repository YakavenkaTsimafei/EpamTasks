import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRunner {
    final static String SUM = "sum = ";

    private static int getResult(String propertiesName, StringBuilder strResult) throws MissingResourceException {
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
                            result += Double.parseDouble(rb.getString("value" + matcher2.group() + rb.getString(key2)));
                        }
                    } else {
                        errorLines++;
                    }
                } catch (Exception e) {
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
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in", result);
        Assertions.assertEquals(3, errorLines);
        Assertions.assertEquals(8.24, Double.parseDouble(result.toString()));
    }

    @Test
    public void testMainCase2() throws MissingResourceException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in1", result);
        Assertions.assertEquals(9, errorLines);
        Assertions.assertEquals(30.242, Double.parseDouble(result.toString()));
    }

    @Test
    public void testMainCase3() throws MissingResourceException {
        StringBuilder result = new StringBuilder();
        int errorLines = getResult("in3", result);
        Assertions.assertEquals(0, errorLines);
        Assertions.assertEquals(1.9, Double.parseDouble(result.toString()), 0.000000000000002);
    }

    @Test(expected = MissingResourceException.class)
    public void testWrongPropertiesName() throws MissingResourceException {
        int errorLines = getResult("resources.in4", new StringBuilder());

    }
}