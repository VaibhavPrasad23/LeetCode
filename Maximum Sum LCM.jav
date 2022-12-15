class Solution {

    static long maxSumLCM(int n) {

        // code here

        long res=0;

        

        for(int i=1;i*i<=n;i++){

            if(n%i==0){

                int a=n/i;

                if(a==i){

                    res+=(long)i;

                }

                else{

                    res+=(long)i+(long)a;

                }

            }

        }

        return res;

    }

}
