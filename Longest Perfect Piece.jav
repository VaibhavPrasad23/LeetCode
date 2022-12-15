//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.longestPerfectPiece(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

  class Solution {

    static int longestPerfectPiece(int[] arr, int N) {

        // code here

        int subarr = 1;

        for(int i = 0 ; i < N ; i++){

            int add = 0;

            while(i < N-1 && arr[i] == arr[i+1]){i++ ; add++;}

            if(i < N-1 && arr[i]+1 == arr[i + 1]){

                // 4 ,5

             

                int lesser = arr[i];

                int greater = arr[i + 1];

                int lesser_index = i;

                int greatest_index = i;

                int start = i;

                loop:

                while(i < N  ){

                    if(arr[i] == lesser){lesser_index = i;}

                    else if(arr[i] == greater){greatest_index = i;}

                    else{break loop;}

                    i++;

                }

                int max = Math.max(greatest_index - start , lesser_index - start);max++;max = max +add;

                subarr = Math.max(subarr , max);

                i = Math.min(greatest_index , lesser_index);

 

            }

            else if(i < N-1 && arr[i]-1 == arr[i + 1]){

                // 4 ,5

                

 

                int lesser = arr[i];

                int greater = arr[i + 1];

                int lesser_index = i;

                int greatest_index = i;

                int start = i;

                loop:

                while(i < N  ){

                    if(arr[i] == lesser){lesser_index = i;}

                    else if(arr[i] == greater){greatest_index = i;}

 

                    else{break loop;}

                    i++;

                }

                int max = Math.max(greatest_index - start , lesser_index - start);max++;max = max +add;

                subarr = Math.max(subarr , max);

                i = Math.min(greatest_index , lesser_index);

 

            }

        }

 

        return subarr;  }

};
