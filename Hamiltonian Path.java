//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean dfs(ArrayList<ArrayList<Integer>> adj, int u,int cnt,int N){
        if(cnt==N) return true;
        vis[u] = true;
        for(int i:adj.get(u)){
            if(!vis[i] && dfs(adj,i,cnt+1,N)) return true;
        }
        vis[u] = false;
        return false;
    }
    boolean[] vis;
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        vis = new boolean[N+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<=N;i++){
            adj.add(new ArrayList<>());
        }
        for(ArrayList<Integer> i: Edges){
            int u = i.get(0);
            int v = i.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i = 1;i<N;i++){
            if(dfs(adj,i,1,N)) return true;
        }
        return false;
    }
} 
