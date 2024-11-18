class Solution {
    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > i) {
                    // Swap matrix[i][j] with matrix[j][i]
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    public void rotate(int[][] matrix) {
        // Transpose the matrix
        transpose(matrix);
        int n = matrix.length;
        int i = 0, j = n - 1;
        while (i < j) {
            // Swap columns from left to right
            for (int k = 0; k < n; k++) {
                int temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
            }
            i++;
            j--;
        }
    }
}
