//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution

{

    int[][] memo;

    int min=Integer.MAX_VALUE;

 public int minDifference(int arr[], int n) 

 { 

     // Your code goes here

     int total =0;

     for(int i=0;i<arr.length;i++)total+=arr[i];

     memo = new int[n][total];

     for(int i=0;i<memo.length;i++){

         Arrays.fill(memo[i],-1);

     }

    findMin(arr,total,0,0);

    return min;

 } 

 int findMin(int[] arr, int total, int idx,int sum){

     if(idx>=arr.length) return sum;

     if(memo[idx][sum]!=-1)return memo[idx][sum];

     if(Math.abs(Math.abs(sum-total)-Math.abs(sum))<min)min=Math.abs(Math.abs(sum-total)-Math.abs(sum));

     int take = findMin(arr, total,idx+1,sum+arr[idx]);

     int dont = findMin(arr,total,idx+1,sum);

     return memo[idx][sum]=Math.min(take,dont);

 }

}
