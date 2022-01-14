package day05;

import java.text.Collator;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class StringStatistics {
    public static Map<Character, Integer> calcStat(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        char[] arr = text.toCharArray();
        Map<Character, Integer> result = new TreeMap<>(new Comparator<>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Collator.getInstance().compare("" + o1, "" + o2);
            }
        });
        for (char ch : arr) {
            if (result.containsKey(ch)) {
                result.put(ch, result.get(ch) + 1);
            } else {
                result.put(ch, 1);
            }
        }
        return result;
    }
}
