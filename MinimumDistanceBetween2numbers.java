//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = Integer.parseInt(str[i]);
            String[] xy = br.readLine().trim().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            Solution g = new Solution();
            System.out.println(g.minDist(a, n, x, y));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minDist(int a[], int n, int x, int y) {
       //setting up default values
    int firstindex=-1,secindex=-1,min_dist=INT_MAX;
    
      for(int i=0;i<n;i++){
          if(a[i]==x){
              firstindex=i;//storing firstindex
          }
          if(a[i]==y){
              secondindex=i;//storing secondindex
          }
          if(firstindex!=-1 && secindex=-1){
              //storing min distance 
              min_dist=min(min_dist,abs(firstindex-secondindex));
          }
      }
      
      //if anyindex not found then return -1
      if(firstindex==-1 || secondindex==-1){
          return -1;
      }
      else{
          return min_dist;  //ans
      }
    }
   }
