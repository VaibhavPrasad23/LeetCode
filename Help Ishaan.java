//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.NthTerm(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution

{

    boolean isPrime(int n)

    {

        for(int i=2;i<=Math.sqrt(n);i++)

        {

            if(n%i==0)

            return false;

        }

        return true;

    }

    public int NthTerm(int n)

    {

        if(n==1)

        return 1;

       if(isPrime(n))

       return 0;

       int left=n-1;

       while(left>=1 && isPrime(left)==false)

         left--;

        

         int right=n+1;

         while(isPrime(right)==false)

          right++;

         return Math.min(n-left,right-n); 

    }

}
