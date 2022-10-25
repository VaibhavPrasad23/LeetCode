//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution{
    static String maxSum(String w,char x[],int b[], int n){
         int currentMax = 0;
        int max = Integer.MIN_VALUE;
        int start = 0, end = 0, s = 0;
        
        for(int i =0; i < w.length(); i++) {
            char c = w.charAt(i);
            Integer val =redefined(c, b, x, n);
            if(val != null) {
                currentMax +=val;
            } else {
                currentMax += c;
            }
            
            if(currentMax > max) {
                max = currentMax;
                start = s;
                end = i;
            }
            
            if(currentMax < 0) {
                currentMax = 0;
                s = i + 1;
            }
        }
        
        return w.substring(start, end + 1);
    }
    
    static Integer redefined(char c, int[] asciiVal, char[] ch, int n) {
        for(int i =0; i < n; i++) {
            if(ch[i] == c) {
                return asciiVal[i];
            }
        }
        return null;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String TE[] = read.readLine().trim().split(" ");
            char x[] = new char[n];
            for(int i = 0;i<n;i++)
            {
                x[i] = TE[i].charAt(0);
            }
            
            String TR[] = read.readLine().trim().split(" ");
            int b[] = new int[n];
            for(int i = 0;i<n;i++)
            {
                b[i] = Integer.parseInt(TR[i]);
            }
           
            Solution ob = new Solution();
            System.out.println(ob.maxSum(w,x,b,n));
        }
    }
}
// } Driver Code Ends
