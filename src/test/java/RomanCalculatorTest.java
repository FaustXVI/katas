import org.fest.assertions.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RomanCalculatorTest {

    @Test
    public void should_add_I_with_I_and_return_II() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("I","I");
        Assertions.assertThat(result).isEqualTo("II");
    }

    @Test
    public void should_add_I_with_II_and_return_III() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("I","II");
        Assertions.assertThat(result).isEqualTo("III");
    }

    @Test
    public void should_add_II_with_I_and_return_III() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("II","I");
        Assertions.assertThat(result).isEqualTo("III");
    }

    @DataProvider(name = "values")
    public Object[][] getValues(){
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
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add(value,null);
        Assertions.assertThat(result).isEqualTo(value);
    }

    @Test(dataProvider = "values")
    public void should_add_null_with_param_and_return_itself(String value) {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add(null, value);
        Assertions.assertThat(result).isEqualTo(value);
    }

    @Test
    public void should_add_II_with_II_and_return_IV() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("II","II");
        Assertions.assertThat(result).isEqualTo("IV");
    }

    @Test
    public void should_add_I_with_III_and_return_IV() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("I","III");
        Assertions.assertThat(result).isEqualTo("IV");
    }

    @Test
    public void should_add_II_with_III_and_return_V() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("II","III");
        Assertions.assertThat(result).isEqualTo("V");
    }

    @Test
    public void should_add_III_with_III_and_return_VI() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("III","III");
        Assertions.assertThat(result).isEqualTo("VI");
    }

    @Test
    public void should_add_IV_with_I_and_return_V() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("IV","I");
        Assertions.assertThat(result).isEqualTo("V");
    }
    @Test
    public void should_add_I_with_IV_and_return_V() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("I","IV");
        Assertions.assertThat(result).isEqualTo("V");
    }
    @Test
    public void should_add_I_with_V_and_return_VI() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("I","V");
        Assertions.assertThat(result).isEqualTo("VI");
    }
    @Test
    public void should_add_II_with_V_and_return_VII() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("II","V");
        Assertions.assertThat(result).isEqualTo("VII");
    }
    @Test
    public void should_add_I_with_VI_and_return_VII() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("I","VI");
        Assertions.assertThat(result).isEqualTo("VII");
    }
    @Test
    public void should_add_II_with_VI_and_return_VIII() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("II","VI");
        Assertions.assertThat(result).isEqualTo("VIII");
    }
    @Test
    public void should_add_I_with_VII_and_return_VIII() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("I","VII");
        Assertions.assertThat(result).isEqualTo("VIII");
    }
    @Test
    public void should_add_II_with_VII_and_return_IX() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("II","VII");
        Assertions.assertThat(result).isEqualTo("IX");
    }
    @Test
    public void should_add_I_with_VIII_and_return_IX() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("I","VIII");
        Assertions.assertThat(result).isEqualTo("IX");
    }
    @Test
    public void should_add_II_with_VIII_and_return_X() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("II","VIII");
        Assertions.assertThat(result).isEqualTo("X");
    }
    @Test
    public void should_add_I_with_IX_and_return_X() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("I","IX");
        Assertions.assertThat(result).isEqualTo("X");
    }
    @Test
    public void should_add_II_with_IX_and_return_XI() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("II","IX");
        Assertions.assertThat(result).isEqualTo("XI");
    }
    @Test
    public void should_add_I_with_X_and_return_XI() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("I","X");
        Assertions.assertThat(result).isEqualTo("XI");
    }

    @Test
    public void should_add_X_with_X_and_return_XX() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("X","X");
        Assertions.assertThat(result).isEqualTo("XX");
    }

    @Test
    public void should_add_XI_with_X_and_return_XXI() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("XI","X");
        Assertions.assertThat(result).isEqualTo("XXI");
    }

    @Test
    public void should_add_XIV_with_I_and_return_XV() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("XIV","I");
        Assertions.assertThat(result).isEqualTo("XV");
    }

    @Test(expectedExceptions = {IllegalArgumentException.class},timeOut = 10)
    public void should_detect_invalid_characters() {
        RomanCalculator calculator = new RomanCalculator();
        calculator.add("#","I");
    }

    @Test
    public void should_add_XXX_with_XX_and_return_L() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("XXX","XX");
        Assertions.assertThat(result).isEqualTo("L");
    }

    @Test
    public void should_add_XXX_with_X_and_return_XL() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("XXX","X");
        Assertions.assertThat(result).isEqualTo("XL");
    }

    @Test
    public void should_add_L_with_L_and_return_C() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("L","L");
        Assertions.assertThat(result).isEqualTo("C");
    }
    @Test
    public void should_add_CCL_with_CCL_and_return_D() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("CCL","CCL");
        Assertions.assertThat(result).isEqualTo("D");
    }
    @Test
    public void should_add_D_with_D_and_return_M() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("D","D");
        Assertions.assertThat(result).isEqualTo("M");
    }
    @Test
    public void should_add_V_with_XL_and_return_VL() {
        RomanCalculator calculator = new RomanCalculator();
        String result = calculator.add("V","XL");
        Assertions.assertThat(result).isEqualTo("VL");
    }
}
