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
            long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.jumpingNums(X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long jumpingNums(long X) {
        long tmp = X; // for storing 1st digit of number X;
        while(tmp>10){
            tmp/=10;
        }
        long ans = 0;
        Queue<Long> q = new ArrayDeque<>();
        for(int i = 1;i<=tmp;i++){
            q.offer((long)i);
        }
        while(!q.isEmpty()){
            long curr = q.poll();
            if(curr>X) continue;
            ans = Math.max(ans,curr);
            long d = curr%10;
            if(d!=9){
                q.offer(curr*10+d+1);
            }
            if(d!=0){
                q.offer(curr*10+d-1);
            }
        }
        return ans;
    }
};
