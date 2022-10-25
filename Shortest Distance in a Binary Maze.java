//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

     int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n=grid.length,m=grid[0].length;
        // Sorting on the basis of time
        PriorityQueue<Triplet> pq=new PriorityQueue<>((a,b)->a.time-b.time);
        pq.offer(new Triplet(source[0],source[1],0));

        // declared array for 4 direction calls
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        boolean[][] visit=new boolean[n][m];
        while(!pq.isEmpty()){
            Triplet curr=pq.poll();
            int r=curr.row;
            int c=curr.col;
            int t=curr.time;
            if(r==destination[0] && c==destination[1]){
                return t;
            }
            for(int i=0;i<4;i++){
                int newRow=r+dx[i];
                int newCol=c+dy[i];
        
                if(newRow>=0 && newCol>=0 && newRow<n && newCol<m && !visit[newRow][newCol] && grid[newRow][newCol]==1){
                    visit[newRow][newCol]=true;
                    pq.offer(new Triplet(newRow,newCol,t+1));
                }
            }
        }
        return -1;
    }
    class Triplet{
        int row,col,time;
        
        Triplet(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
}
