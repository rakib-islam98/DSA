import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        // //checking each rows
        // for(int row=0;row<9;row++) {
        //     HashSet<Character> seen=new HashSet<>();
        //     for(int col=0;col<9;col++) {
        //         if(board[row][col]=='.') continue;
        //         if(seen.contains(board[row][col])) return false;
        //         seen.add(board[row][col]);
        //     }
        // }
        // //Checking each cols
        // for(int col=0;col<9;col++) {
        //     HashSet<Character> seen=new HashSet<>();
        //     for(int row=0;row<9;row++) {
        //         if(board[row][col]=='.') continue;
        //         if(seen.contains(board[row][col])) return false;
        //         seen.add(board[row][col]);
        //     }
        // }
        // //checking each square
        // for(int square=0;square<9;square++) {
        //     HashSet<Character> seen=new HashSet<>();
        //     for(int i=0;i<3;i++) {
        //         for(int j=0;j<3;j++) {
        //             //squareRowIdx=(square/3), ElementRowIdx=(squareRowIdx*3+i)
        //             int row=(square/3)*3+i;
        //             //squareColIdx=(square%3), ElementColIdx=(squareColIdx*3+j)
        //             int col=(square%3)*3+j;
        //             if(board[row][col]=='.') continue;
        //             if(seen.contains(board[row][col])) return false;
        //             seen.add(board[row][col]);
        //         }
        //     }
        // }
        // return true;

        HashMap<Integer,HashSet<Character>> rows=new HashMap<>();
        HashMap<Integer,HashSet<Character>> cols=new HashMap<>();
        HashMap<String,HashSet<Character>> squares=new HashMap<>();

        for(int r=0;r<9;r++) {
            for(int c=0;c<9;c++) {
                String squareKey=(r/3)+","+(c/3);
                char val=board[r][c];
                if(val=='.') continue;

                if(rows.computeIfAbsent(r,k->new HashSet<>()).contains(val)||
                cols.computeIfAbsent(c,k->new HashSet<>()).contains(val)||
                squares.computeIfAbsent(squareKey,k->new HashSet<>()).contains(val)
                )   return false;
                
                System.out.println(rows);
                System.out.println(cols);
                System.out.println(squares);

                rows.get(r).add(val);
                cols.get(c).add(val);
                squares.get(squareKey).add(val);
            }
        }

        return true;
    }
    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
        
    }
}