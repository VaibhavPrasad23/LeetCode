// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A[] = read.readLine().split(" ");
            
            String S = A[0];
            String T = A[1];

            Solution ob = new Solution();
            System.out.println(ob.shortestUnSub(S,T));
        }
    }
}// } Driver Code Ends


//User function Template for Java



class Solution {
    static int shortestUnSub(String S, String T) {
        // code here
        int n = S.length();
        int m = T.length();
        int[][] dp = new int[n+1][m+1];
        int MAX = 600;
        
        for(int i=0; i<=n; i++){
            dp[i][0] = 1; // base case
        }
        for(int i=0; i<=m; ++i){
            dp[0][i] = MAX;//not possible case
        }
        // remember dp[0][0] is not possible or -1
        // followed 1 indexing so carefully get array elements
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=m; ++j){
                int k;
                for(k=j-1; k>=0; --k){
                    if(T.charAt(k) == S.charAt(i-1)){
                        break;
                    }
                }
                if(k == -1){
                    dp[i][j] = 1;//shortest uncommon is 1
                }
                else{
                    // can take or leave the common character
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i-1][k]);// take string from k-1 so of length k
                }
            }
        }
        return dp[n][m]>=MAX?-1:dp[n][m];
    }

};
