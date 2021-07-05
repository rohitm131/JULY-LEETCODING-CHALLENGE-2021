class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        int row = mat.length;
        int col = mat[0].length;
        
        if(row*col != r*c) return mat;
        
        int sc = 0;
        int sr = 0;
        
        int[][] matrix = new int[r][c];
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(sc == c) {
                    sr++;
                    sc = 0;
                }
                matrix[sr][sc] = mat[i][j];
                sc++;
            }
        }
        
        return matrix;
    }
}
