import java.util.*;

public class RomanTranslator {

    private final RomanMap intToRoman = new RomanMap();

    public int toInt(String operand) {
        int value = 0;
        TranslationContext translationContext = new TranslationContext(operand);
        Set<Map.Entry<Integer, String>> entries = intToRoman.entrySet();
        while (translationContext.isValid()) {
            translationContext.startTranslation();
            for (Map.Entry<Integer, String> entry : entries) {
                String romanString = entry.getValue();
                Integer integer = entry.getKey();
                value += translationContext.check(romanString, integer);
            }
            translationContext.endTranslation();
        }
        return value;
    }

    public String toRoman(int sum) {
        String result = "";
        Set<Integer> integers = intToRoman.keySet();
        for (Integer integer : integers) {
            while (sum >= integer) {
                result += intToRoman.get(integer);
                sum -= integer;
            }
        }
        return result;
    }

}
