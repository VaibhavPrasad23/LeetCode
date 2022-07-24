//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int key = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.binarysearch(arr, n, key));
            T--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
   int binarysearch(int arr[], int n, int k) {
       
       int beg=0;
       int end=n-1;
       int count=0;
    
       while(count<n)
       {
          int mid=(beg+end)/2;
           count++;    
           if(k==arr[mid])
           {
               return mid;
           }
           else if(k>arr[mid])
           {
               beg=mid+1;
           }
           else
           {
               end=mid-1;
           }
       }
       return -1;
   }
}