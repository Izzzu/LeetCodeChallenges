package may;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap();
        for (char c: s.toCharArray()) {

                int v = map.getOrDefault(c, 0);
                map.put(c, v+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
