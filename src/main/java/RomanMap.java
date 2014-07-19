import java.util.*;

public class RomanMap {

    TreeMap<Integer, String> romanNumbers = createIntToRomanMap();

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

    public String get(Integer key) {
        return romanNumbers.get(key);
    }

    public Set<Integer> keySet() {
        return romanNumbers.keySet();
    }

    public Set<Map.Entry<Integer, String>> entrySet() {
        return romanNumbers.entrySet();
    }

    private class NegateComparator implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }
}
