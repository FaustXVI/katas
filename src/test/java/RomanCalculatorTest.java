import org.fest.assertions.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RomanCalculatorTest {

    private RomanTranslator romanTranslator = new RomanTranslator();

    @DataProvider(name = "values")
    public Object[][] getValues() {
        return new String[][]{
                {"I"},
                {"V"},
                {"X"},
                {"L"},
                {"C"},
                {"D"},
                {"M"},
        };
    }

    @Test(dataProvider = "values")
    public void should_add_param_with_null_and_return_itself(String value) {
        RomanCalculator calculator = new RomanCalculator(romanTranslator);
        String result = calculator.add(value, null);
        Assertions.assertThat(result).isEqualTo(value);
    }

    @Test(dataProvider = "values")
    public void should_add_null_with_param_and_return_itself(String value) {
        RomanCalculator calculator = new RomanCalculator(romanTranslator);
        String result = calculator.add(null, value);
        Assertions.assertThat(result).isEqualTo(value);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class}, timeOut = 10)
    public void should_detect_invalid_characters() {
        RomanCalculator calculator = new RomanCalculator(romanTranslator);
        calculator.add("#", "I");
    }

    @DataProvider(name = "additions")
    public Object[][] getAdditions() {
        return new String[][]{
                {"I", "I", "II"},
                {"I", "II", "III"},
                {"II", "I", "III"},
                {"II", "II", "IV"},
                {"I", "III", "IV"},
                {"II", "III", "V"},
                {"III", "III", "VI"},
                {"IV", "I", "V"},
                {"I", "IV", "V"},
                {"I", "V", "VI"},
                {"II", "V", "VII"},
                {"I", "VI", "VII"},
                {"II", "VI", "VIII"},
                {"I", "VII", "VIII"},
                {"II", "VII", "IX"},
                {"I", "VIII", "IX"},
                {"II", "VIII", "X"},
                {"I", "IX", "X"},
                {"II", "IX", "XI"},
                {"I", "X", "XI"},
                {"X", "X", "XX"},
                {"XI", "X", "XXI"},
                {"XIV", "I", "XV"},
                {"XXX", "XX", "L"},
                {"XXX", "X", "XL"},
                {"L", "L", "C"},
                {"CCL", "CCL", "D"},
                {"D", "D", "M"},
                {"V", "XL", "VL"},
        };
    }

    @Test(dataProvider = "additions")
    public void should_add_numbers_correctly(String operand1, String operand2, String expected) {
        RomanCalculator calculator = new RomanCalculator(romanTranslator);
        String result = calculator.add(operand1, operand2);
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
