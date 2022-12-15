//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
   static boolean isValid(int i,int j,int m,int n){
        return (i<0||j<0||i>=m||j>=n)?false:true;
    }
    static long numOfWays(int m, int n)
    {
      int count=1;
      long ans=0L;
      long mod=1000000007;
      long mul=m*n;
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              if(isValid(i+2,j+1,m,n))count++;
              if(isValid(i+2,j-1,m,n))count++;
              if(isValid(i-2,j+1,m,n))count++;
              if(isValid(i-2,j-1,m,n))count++;
              if(isValid(i+1,j+2,m,n))count++;
              if(isValid(i+1,j-2,m,n))count++;
              if(isValid(i-1,j+2,m,n))count++;
              if(isValid(i-1,j-2,m,n))count++;
              ans=(ans%mod+(mul-count))%mod;
              count=1;
          }
      }
      return ans;
    }
}
