class Solution {
    public boolean canJump(int[] nums) {
        int gas = 0;  // Maximum reach so far
        for (int i = 0; i < nums.length; i++) {
            if (gas < i) {
                return false;  // Current index is not reachable
            }
            gas = Math.max(gas, i + nums[i]);
            if (gas >= nums.length - 1) {
                return true;  // Early exit if we can already reach the end
            }
        }
        return true;
    }
}
