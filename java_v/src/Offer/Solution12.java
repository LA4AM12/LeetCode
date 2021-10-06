package Offer;

public class Solution12 {
    int[][] direc = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length,n = board[0].length;
        boolean[][] visited = new boolean[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(i,j,0,visited,board,word))
                    return true;
            }
        }

        return false;
    }

    //检查 m n 处的是否匹配word[cur]
    public boolean check(int m ,int n, int cur,boolean[][] visited,char[][] board,String word){
        if (board[m][n] != word.charAt(cur))
            return false;
        if (cur == word.length()-1)
            return true;

        visited[m][n] = true;
        for (int i = 0; i < direc.length; i++) {
            int _m = m + direc[i][0], _n = n + direc[i][1];
            if (_m >= 0 && _m < board.length && _n >= 0 && _n < board[0].length && !visited[_m][_n] && check(_m,_n,cur+1,visited,board,word))
                return true;
        }

        visited[m][n] = false;
        return false;
    }
}
