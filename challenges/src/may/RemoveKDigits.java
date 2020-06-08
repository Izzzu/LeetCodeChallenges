package may;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {

        if (k == 0) return num;
        if(k == num.length()) return "0";
        Stack<Character> s = new Stack<>();
        int i = 0;
        while(i<num.length()) {
            while (!s.isEmpty() && k > 0 && num.charAt(i) < s.peek()) {
                s.pop();
                k--;
            }
            s.push(num.charAt(i));
            i++;
        }
        for (int j = 0; j < k; j++) {
            s.pop();
        }

        StringBuilder res = new StringBuilder();

        while (!s.isEmpty()) {
            res.append(s.pop());
        }

        res.reverse();

        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        if (res.length() == 0) {
            return "0";
        }
        return res.toString();
    }

    public String removeKdigits2(String num, int k) {

        if (k == 0) return num;

        StringBuilder res = new StringBuilder(num);

        for (int i = 0; i < k; i++) {
            int j = 0;
            while(j<res.length()-1 && res.charAt(j) <= res.charAt(j+1)) {
                j++;
            }
            res.deleteCharAt(j);
        }

        while (res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        if (res.length() == 0) {
            return "0";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("1234567890",
                9));
    }

}

