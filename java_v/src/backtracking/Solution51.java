package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : LA4AM12
 * @create : 2022-01-12 21:07:41
 * @description : N-Queens
 */
public class Solution51 {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] line : chessboard) {
            Arrays.fill(line, '.');
        }
        backtrack(chessboard, 0);
        return ans;
    }

    private void backtrack(char[][] chessboard, int row) {
        if (row == chessboard.length) {
            ans.add(Arrays.stream(chessboard).map(String::new).collect(Collectors.toList()));
            return;
        }
        for (int j = 0; j < chessboard.length; j++) {
            if (check90(chessboard, row, j) && check45(chessboard, row, j) && check135(chessboard, row, j)) {
                chessboard[row][j] = 'Q';
                backtrack(chessboard, row + 1);
                // backtrack
                chessboard[row][j] = '.';
            }
        }
    }

    private boolean check45(char[][] chessboard, int i, int j) {
        while (i >= 0 && j < chessboard.length) {
            if (chessboard[i--][j++] == 'Q')
                return false;
        }
        return true;
    }

    private boolean check90(char[][] chessboard, int i, int j) {
        while (i >= 0) {
            if (chessboard[i--][j] == 'Q')
                return false;
        }
        return true;
    }

    private boolean check135(char[][] chessboard, int i, int j) {
        while (i >= 0 && j >= 0) {
            if (chessboard[i--][j++] == 'Q')
                return false;
        }
        return true;
    }
}
