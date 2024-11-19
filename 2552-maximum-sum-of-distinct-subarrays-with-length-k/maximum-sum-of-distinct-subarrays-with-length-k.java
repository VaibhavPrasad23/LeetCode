import java.util.HashMap;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        long sum = 0, maxSum = 0;
        int duplicateCount = 0;

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            if (countMap.get(nums[i]) == 2) duplicateCount++;
            sum += nums[i];
        }
        
        // Update the maximum sum if no duplicates exist
        if (duplicateCount == 0) {
            maxSum = sum;
        }

        // Slide the window
        for (int right = k, left = 0; right < nums.length; right++, left++) {
            // Add the new element at the right
            countMap.put(nums[right], countMap.getOrDefault(nums[right], 0) + 1);
            if (countMap.get(nums[right]) == 2) duplicateCount++;
            sum += nums[right];

            // Remove the old element at the left
            countMap.put(nums[left], countMap.get(nums[left]) - 1);
            if (countMap.get(nums[left]) == 1) duplicateCount--;
            sum -= nums[left];

            // Update maxSum if no duplicates
            if (duplicateCount == 0) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }}