import java.util.HashMap;

public class Hashing {
    public boolean isPalindrome(String input) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (hm.containsKey(input.charAt(i))) {
                hm.replace(input.charAt(i), hm.get(input.charAt(i)) + 1);
            }
            else {
                hm.put(input.charAt(i), 1);
            }
        }

        boolean oddAllowed = true;

        if (input.length() % 2 == 1) {
            for (Character c : hm.keySet()) {
                if (hm.get(c) % 2 == 1) {
                    if (oddAllowed) {
                        oddAllowed = false;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        
        else {
            for (Character c : hm.keySet()) {
                if (hm.get(c) % 2 == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public String indices(int[] arr, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                return i + " " + hm.get(arr[i]);
            }
            else {
                hm.put(target - arr[i], i);
            }
        }
        return "Make sure all preconditions are met";
    }

    public boolean isReplaceable(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        HashMap<Character, Character> hm = new HashMap<Character, Character>();
        for (int i = 0; i < a.length(); i++) {
            if (hm.containsKey(a.charAt(i))) {
                if (!(hm.get(a.charAt(i)) == b.charAt(i))) {
                    return false;
                }
            }
            else {
                hm.put(a.charAt(i), b.charAt(i));
            }
        }
        return true;
    }
}
