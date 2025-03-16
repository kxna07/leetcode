class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256]; // Frequency array for all ASCII characters
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right)]++; // Increase frequency of right character

            // If character appears more than once, move left pointer
            while (freq[s.charAt(right)] > 1) {
                freq[s.charAt(left)]--; // Reduce frequency of left character
                left++; // Shrink window
            }

            // Update maximum substring length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}

class LongestSubstrWoRepeatingChars{
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    // Output: 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   // Output: 3
    }
}
