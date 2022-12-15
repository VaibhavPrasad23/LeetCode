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
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution

{

    public int characterReplacement(String s, int k)

    {

        int visited[]=new int[26];

        int res=0;

        int j=0;

        for(int i=0;i<s.length();i++)

        {

            visited[s.charAt(i)-'A']++;

            if(check(visited,k))

            {

                res=Math.max(res,i-j+1);

            }

            else

            {

                while(j<s.length() && check(visited,k)==false)

                { 

                    visited[s.charAt(j)-'A']--;

                    j++;

                }

             }

        }

        return res;

    }

    public boolean check(int visited[],int k)

    {

        int max=-999;

        int total=0;

        for(int i=0;i<26;i++)

        {

            total=total+visited[i];

            if(max<visited[i])

            max=visited[i];

        }

        if(total-max<=k)

        return true;

        return false;

      }

}
