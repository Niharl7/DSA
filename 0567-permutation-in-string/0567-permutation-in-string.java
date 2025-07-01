class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] need = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < n; i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++)
            if (need[i] == window[i]) matches++;

        for (int left = 0, right = n; right < m; left++, right++) {
            if (matches == 26) return true;

            int inChar = s2.charAt(right) - 'a';
            int outChar = s2.charAt(left) - 'a';

            window[inChar]++;
            if (window[inChar] == need[inChar]) matches++;
            else if (window[inChar] == need[inChar] + 1) matches--;

            window[outChar]--;
            if (window[outChar] == need[outChar]) matches++;
            else if (window[outChar] == need[outChar] - 1) matches--;
        }

        return matches == 26;
    }
}
