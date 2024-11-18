import java.util.*;

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];

        if (k == 0)
            return ans;

        if (k > 0) {
            int wsum = 0;
            for (int i = 1; i <= k; i++) {
                wsum += code[i % n];
            }
            ans[0] = wsum;

            for (int l = 1, r = k + 1; l < n; r++, l++) {
                wsum = wsum - code[l] + code[r % n];
                ans[l] = wsum;
            }
            return ans;
        }

        // k < 0
        k = -k;
        int wsum = 0;
        for (int i = n - k; i < n; i++) {
            wsum += code[i];
        }
        ans[0] = wsum;

        for (int r = 0, l = n - k; r < n - 1; r++, l++) {
            wsum = wsum - code[l % n] + code[r];
            ans[r + 1] = wsum;
        }

        return ans;
    }
}
