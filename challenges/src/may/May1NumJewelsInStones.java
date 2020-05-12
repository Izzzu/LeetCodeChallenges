package may;

import java.util.HashSet;
import java.util.Set;

public class May1NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {

        Set<Character> jewels = new HashSet<Character>();
        for (char c : J.toCharArray()) {
            jewels.add(c);
        }
        int count = 0;
        for (Character c : S.toCharArray()) {
            if (jewels.contains(c)) {
                count++;
            }
        }

        return count;
    }
}
