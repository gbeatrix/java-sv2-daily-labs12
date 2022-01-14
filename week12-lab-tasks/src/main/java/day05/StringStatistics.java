package day05;

import java.util.Map;
import java.util.TreeMap;

public class StringStatistics {
    public static Map<Character, Integer> calcStat(String text) {
        if(text == null){
            throw new IllegalArgumentException("text cannot be null");
        }
        char[] arr = text.toCharArray();
        Map<Character, Integer> result = new TreeMap<>();
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
