class NumMatrix {
    // int[][] matrixSum;
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;

        //1D prefix
        // matrixSum=new int[row][col+1];
        // for(int i=0;i<row;i++) {
        //     for(int j=0;j<col;j++) {
        //         matrixSum[i][j+1]=matrixSum[i][j]+matrix[i][j];
        //     }
        // }

        //2D prefix
        prefix=new int[row+1][col+1];
        for(int r=0;r<row;r++) {
            int prefixSum=0;
            for(int c=0;c<col;c++) {
                prefixSum+=matrix[r][c];
                int abovePrefixSum=prefix[r][c+1];
                prefix[r+1][c+1]=prefixSum+abovePrefixSum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // int sum=0;
        // for(int i=row1;i<=row2;i++) {
        //     // for(int j=col1;j<=col2;j++) {
        //     //     sum+=matrixSum[i][j];
        //     // }
        //     sum+=matrixSum[i][col2+1]-matrixSum[i][col1];
        // }
        // return sum;
        row1++;col1++;row2++;col2++;
        //ans=totalRectangleSum-leftSum-UpSum+topLeftCorner
        return prefix[row2][col2]-prefix[row2][col1-1]-prefix[row1-1][col2]+prefix[row1-1][col1-1];

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
public class RangeSumQuery2D {
    public static void main(String[] args) {
        NumMatrix matrix=new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}
        });
        System.out.println(matrix.sumRegion(2, 1, 4, 3));
        System.out.println(matrix.sumRegion(1, 1, 2, 2));
        System.out.println(matrix.sumRegion(1, 2, 2, 4));
        // 8 11 12
    }
}