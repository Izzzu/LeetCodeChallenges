package may;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {

        int s1len = s1.length();
        int s2len = s2.length();

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (int i = 0; i < s1len; i++) {
            arr[s1.charAt(i)-'a']++;
            arr[s2.charAt(i)-'a']--;
        }

        if (check(arr)) return true;

        for (int i = s1len; i < s2len; i++) {
            arr[s2.charAt(i)-'a']--;
            arr[s2.charAt(i-s1len)-'a']++;
            if (check(arr)) return true;

        }

        return false;
    }

    private boolean check(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
