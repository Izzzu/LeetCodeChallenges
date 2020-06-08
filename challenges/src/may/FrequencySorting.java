package may;

import java.util.HashMap;
import java.util.Map;

public class FrequencySorting {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            Integer v = map.getOrDefault(c, 0);
            map.put(c, v+1);
        }
        StringBuilder string = new StringBuilder();
        while(string.length()<s.length()) {
            char cMax = findMax(map);
            for (int i = 0; i < map.get(cMax); i++) {
                    string.append(cMax);
            }

            map.remove(cMax);
        }

        return string.toString();
    }

    private char findMax(Map<Character, Integer> map) {
        int max = Integer.MIN_VALUE;
        char c = '?';
        for (Character character : map.keySet()) {
            if (map.get(character)  > max) {
                max = map.get(character) ;
                c = character;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new FrequencySorting().frequencySort("tree"));
    }
}
