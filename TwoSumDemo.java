import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int []arr = new int[2]; // Array to store the indices of the two numbers

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Check each number with all numbers ahead of it
            for (int j = i + 1; j < nums.length; j++) {
                // If the sum of nums[i] and nums[j] equals target, store the indices
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr; // Return immediately once a valid pair is found
                }
            }
        }
        return arr; // Returns default (0,0) if no pair is found (this may need better handling)
    }
}

class TwoSumDemo {
    public static void main(String[] args) {
        Solution s = new Solution();
        int []arr = {2, 7, 11, 5}; // Example input array
        int target = 13; // Example target sum

        // Print the indices of the two numbers whose sum equals the target
        System.out.println(Arrays.toString(s.twoSum(arr, target)));
    }
}
