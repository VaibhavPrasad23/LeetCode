//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String result = "";
    static String createRepeat(String str, int n)
    {
        String res = "";
        for(int i = 0;i < n;i++)
            res += str;
        return res;
    }
    static int getNumber(Stack<String> stack)
    {
        String res = "";
        while(!stack.isEmpty())
        {
            char ch = stack.peek().charAt(0);
            if(Character.isDigit(ch))
            {
                res = ch + res;
                stack.pop();
            }
            else
            {
                break;
            }
        }
        return Integer.parseInt(res);
    }
    
    static int decode(String s,int startPoint)
    {
        Stack<String> stack = new Stack<>();
        int i = startPoint;
        stack.push(s.charAt(i++)+"");
        stack.push(s.charAt(i++)+"");
        while(stack.size() > 1 && i < s.length())
        {
            char ch = s.charAt(i++);
            if(ch != ']')
            {
                stack.push(ch+"");
            }
            else
            {
                String curStr = "";
                while(!stack.peek().equals("["))
                {
                    curStr = stack.pop() + "" + curStr;
                }
                stack.pop();
                int repeat = getNumber(stack);
                curStr = createRepeat(curStr,repeat);
                stack.push(curStr);
            }
        }
        result = stack.pop() + result;
        return i;
    }
    static String decodedString(String s){
        
        int end = 0;
        while(end < s.length())
        {
            end = decode(s,end);
        }
        String res = result;
        result = "";
        return res;
    }
}
