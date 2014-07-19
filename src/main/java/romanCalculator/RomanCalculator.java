package romanCalculator;

public class RomanCalculator {

    private final RomanTranslator romanTranslator;

    public RomanCalculator(RomanTranslator romanTranslator) {
        this.romanTranslator = romanTranslator;
    }

    public String add(String operand1, String operand2) {
        int value1 = romanTranslator.toInt(operand1);
        int value2 = romanTranslator.toInt(operand2);
        int sum = value1 + value2;
        return romanTranslator.toRoman(sum);
    }

}
