//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


class Solution{
   ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        return subsetSumsUtil(arr, 0, N);
    }
    
    ArrayList<Integer> subsetSumsUtil(ArrayList<Integer> arr, int idx, int N){
        if(idx == N - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(arr.get(idx));
            return list;
        }
        ArrayList<Integer> list = subsetSumsUtil(arr, idx + 1, N);
        int size = list.size();
        for(int i = 0; i < size; i++) {
            list.add(list.get(i) + arr.get(idx));
        }
        
        return list;
    }}
