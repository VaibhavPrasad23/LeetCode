//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for (int i=0; i<n ; i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n); 

           	for (int i = 0; i < n; i++) { 
				System.out.print(ans[i]+" ");
			} 
            System.out.println();
            t--;
        }
    } 
} 
  


// } Driver Code Ends


//User function Template for Java


class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{   
	    
	   long p[] = new long[n];
        if (n < 1) return p;
        long prod = 1;
        for(int i=0; i<n; i++){
           prod = prod * nums[i];
           p[i] = prod;
        }
        prod = 1;
        for(int i=n-1; i>0; i--){
          p[i] = p[i-1] * prod;
          prod = prod * nums[i];
        }
        p[0] = prod;
        return p; 
       
	} 
} 
// Use two single For loops (Starting from Left and Right respectively)
// First loop starts from left till end and will create product array till the length (without any element exclusion). 
// Second loop starts from end to left and will eliminate the current index product value from the product array for the current index. 
// And It will also store the current index product value in the prod variable to be used in next index usage.
