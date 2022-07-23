//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            int h = a[0],m = a[1];
            Solution obj = new Solution();
            int res = obj.maxLevel(h,m);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
  public static int maxLevel_dp(int h, int m, int[][] dp, boolean flag) {
        if(h <= 0 || m <= 0)
            return -1;
            
        if(dp[h][m] != -1)
            return dp[h][m];
            
        if(flag==true) {
            flag = false;
            return dp[h][m] = maxLevel_dp(h + 3, m + 2, dp, flag) + 1;
        } else {
            flag = true;
            return dp[h][m] = Math.max(maxLevel_dp(h - 5, m - 10, dp, flag), maxLevel_dp(h - 20, m + 5, dp, flag)) + 1;
        }
    }
    
    public static int maxLevel(int h,int m) {
        int[][] dp = new int[2001][2001];
        for(int[] d : dp)
            Arrays.fill(d, -1);
        return maxLevel_dp(h, m, dp, true);
    }
}
