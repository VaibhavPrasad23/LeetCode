//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> downwardDigonal(int N, int A[][])
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int r = A.length;
        for(int i = 0;i<r;i++){
            for(int j = 0;j<=i;j++){
                ans.add(A[j][i-j]);
            }
        }
        int k = r-1;
        int tmp = k;
        for(int i = 1;i<r;i++){
            for(int j = 0;j<tmp;j++){
                ans.add(A[i+j][k-j]);
            }
            tmp--;
        }
        return ans;
    }
}
