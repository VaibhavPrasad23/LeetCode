//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution 

{

    public static int beautySum(String s) 

    {

        int beautySum=0;

        int limit = s.length();

        

        for(int i=0; i<limit; i++)

        {

            int[] freq = new int[26];

            for(int j=i; j<limit; j++)

            {

                freq[s.charAt(j)-'a']++;

                beautySum += calculateBeauty(freq);

            }

        }

        return beautySum;

    }

    

    public static int calculateBeauty(int[] freq)

    {

        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;

        for(int i=0; i<26; i++)

        {

            if(freq[i]!=0)

            {

                max = Math.max(max, freq[i]);

                min = Math.min(min, freq[i]);

            }

        }

        return max-min;

    }

}
