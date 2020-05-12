package may;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> magazineSet  = new HashMap<Character, Integer>();
        for (char character : magazine.toCharArray()) {
            Integer orDefault = magazineSet.getOrDefault(character, 0);
            magazineSet.put(character, orDefault+1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (magazineSet.containsKey(c)) {
                Integer val = magazineSet.get(c);
                if (val ==1) {
                    magazineSet.remove(c);
                } else {
                    magazineSet.put(c, val-1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("aa", "aba"));
    }
}