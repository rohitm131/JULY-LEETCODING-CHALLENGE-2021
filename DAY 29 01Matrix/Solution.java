class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 0) q.add(new int[]{i, j});
                else mat[i][j] = -1;
            }
        }
        
        int[][] dirs = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            while(size-- > 0) {
                int[] cell = q.poll();
                for(int[] dir : dirs) {
                    int row = cell[0] + dir[0];
                    int col = cell[1] + dir[1];
                    if(row<0 || col<0 || row==mat.length || col==mat[0].length || mat[row][col]!=-1) continue;
                    mat[row][col] = level;
                    q.add(new int[]{row, col});
                }
            }
        }
        return mat;
    }
}
