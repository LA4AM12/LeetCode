package Offer;

public class Solution13 {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return enter(m, n, 0, 0, k,visited);
    }

    public int enter(int m, int n, int r, int c, int k,boolean[][] visited) {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) return 0;

        int sum = c % 10 + c / 10 % 10 + c / 100 % 10 + r % 10 + r / 10 % 10 + r / 100 % 10;
        if (sum > k) return 0;
        visited[r][c] = true;
        return enter(m, n, r + 1, c, k,visited) + enter(m, n, r, c + 1, k,visited) + enter(m, n, r - 1, c, k,visited) + enter(m, n, r, c - 1, k,visited) + 1;
    }
}
