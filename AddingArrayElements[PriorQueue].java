//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().minOperations(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

//User function Template for Java

class Solution {
    int minOperations(int[] arr, int n, int k) {
       int c=0;
     PriorityQueue<Integer>heap=new PriorityQueue<>();
     for(int i=0;i<n;i++)
     {
         heap.add(arr[i]);
     }
    
    if(heap.peek()>=k)
    {
        return 0;
    }
    else
    {
     while(heap.peek()<k)
     {
        int a=heap.poll();
        int b=heap.poll();
        int sum=a+b;
        c++;
        heap.add(sum);
     }
    }
    return c;
    }
}
