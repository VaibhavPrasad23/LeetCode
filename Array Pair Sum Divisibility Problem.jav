//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
   public boolean canPair(int[] nums, int k) {
        for(int i =0; i<nums.length;i++){
            nums[i] = nums[i]%k;
        }
        Map<Integer,Integer> reminderMap = new HashMap<Integer,Integer>();
        for(int a : nums){
            if(reminderMap.containsKey(a)){
                reminderMap.put(a, reminderMap.get(a)+1);
            }
            else{
                reminderMap.put(a,1);
            }
        }
        for (int i : reminderMap.keySet()) {
            if(reminderMap.get(i)==k/2 && reminderMap.get(i)%2!=0) return false;
            else if(i==0 && reminderMap.get(i)%2!=0) return false;
            else if(i!=0){
            if(reminderMap.get(i) != reminderMap.get(k-i)){
                return false;
            }
            }
            
        }
        return true;
    }
}
