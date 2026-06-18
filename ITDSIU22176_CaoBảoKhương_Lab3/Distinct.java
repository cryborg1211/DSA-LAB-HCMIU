import java.util.*;

public class Distinct {
    public static int solve(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0)
            return 0;

        int maxLen = 0;
        int left = 0;
        int distinctCount = 0;
        int[] freq = new int[256];

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (freq[rightChar] == 0) {
                distinctCount++;
            }
            freq[rightChar]++;

            while (distinctCount > k) {
                char leftChar = s.charAt(left);
                freq[leftChar]--;
                if (freq[leftChar] == 0) {
                    distinctCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabbcbbbccbcb";
        int k = 2;
        System.out.println("Longest substring with at most " + k + " distinct characters: " + solve(s, k));
    }
}
