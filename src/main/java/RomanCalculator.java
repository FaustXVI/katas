import java.util.*;

public class RomanCalculator {

    TreeMap<Integer, String> intToRoman = createIntToRomanMap();

    private TreeMap<Integer, String> createIntToRomanMap() {
        Map<Integer, String> basicMap = createBasicMap();
        TreeMap<Integer, String> map = new TreeMap<>(new NegateComparator());
        for (Map.Entry<Integer, String> basicEntry : basicMap.entrySet()) {
            Integer basicKey = basicEntry.getKey();
            String basicValue = basicEntry.getValue();
            map.put(basicKey, basicValue);
            map.putAll(generateSubstractCases(basicMap, basicKey, basicValue));
        }
        return map;
    }

    private Map<Integer, String> generateSubstractCases(Map<Integer, String> basicMap, Integer basicKey, String basicValue) {
        Map<Integer, String> map = new HashMap<>();
        for (Map.Entry<Integer, String> entry : basicMap.entrySet()) {
            Integer entryKey = entry.getKey();
            if (entryKey < (basicKey / 2)) {
                map.put(basicKey - entryKey, entry.getValue() + basicValue);
            }
        }
        return map;
    }

    private Map<Integer, String> createBasicMap() {
        Map<Integer, String> basicMap = new HashMap<>();
        basicMap.put(1000, "M");
        basicMap.put(500, "D");
        basicMap.put(100, "C");
        basicMap.put(50, "L");
        basicMap.put(10, "X");
        basicMap.put(5, "V");
        basicMap.put(1, "I");
        return basicMap;
    }

    public String add(String operand1, String operand2) {
        int value1 = romanToInt(operand1);
        int value2 = romanToInt(operand2);
        int sum = value1 + value2;
        return intToRoman(sum);
    }

    private String intToRoman(int sum) {
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

    private int romanToInt(String operand) {
        int value = 0;
        Set<Map.Entry<Integer, String>> entries = intToRoman.entrySet();
        while (operand != null && !operand.isEmpty()) {
            String oldOperand = operand;
            for (Map.Entry<Integer, String> entry : entries) {
                String romanString = entry.getValue();
                if (operand.startsWith(romanString)) {
                    Integer integer = entry.getKey();
                    value += integer;
                    operand = operand.substring(romanString.length());
                }
            }
            if (oldOperand == operand) {
                throw new IllegalArgumentException("Invalid character");
            }
        }
        return value;
    }

    private class NegateComparator implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }
}
