import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int p[] = new int[n];
            for(int i = 0;i < n;i++)
                p[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixChainOrder(p, n));
        }
    }
}// } Driver Code Ends

class Solution{
    public static class Pair{
        String order;
        int val;
        Pair(String order,int val){
            this.order = order;
            this.val = val;
        }
    }
    static String matrixChainOrder(int p[], int n){
        // code here
        // int ans = matrixChainOrderUtil(p,n,1,n-1);
        Pair[][] dp = new Pair[n+1][n+1];
        return matrixChainOrderUtil(p,n,1,n-1,dp).order;
        
    }
    
    static Pair matrixChainOrderUtil(int[] p,int n,int i,int j,Pair[][] dp){
        if(i == j){
            return new Pair(""+(char)(i-1+'A'),0);
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        int minCost = Integer.MAX_VALUE;
        String ans = "";
        for(int partition=i; partition<j; ++partition){
            Pair p1 = matrixChainOrderUtil(p,n,i,partition,dp);
            Pair p2 = matrixChainOrderUtil(p,n,partition+1,j,dp);
            int temp = p1.val+p2.val+(p[i-1]*p[partition]*p[j]);
            // minCost = Math.min(minCost,temp);
            if(temp<minCost){
                minCost = temp;
                ans = p1.order+p2.order;
            }
            
        }
        dp[i][j] = new Pair("("+ans+")",minCost);
        return dp[i][j];
    }
}
