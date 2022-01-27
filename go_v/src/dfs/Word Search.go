package dfs

// leetcode-0079  2021/03/06

type pair struct {
	x, y int
}

func exist(board [][]byte, word string) bool {
	var direction = []pair{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	rows, cols, length := len(board), len(board[0]), len(word)

	var match func(int, int, int) bool
	match = func(row, col, cur int) bool {
		if board[row][col] != word[cur] {
			return false
		}
		if cur == length-1 {
			return true
		}
		temp := board[row][col]
		board[row][col] = '#'
		defer func() { board[row][col] = temp }()

		for _, dir := range direction {
			r, c := row+dir.x, col+dir.y
			if r >= 0 && r < rows && c >= 0 && c < cols && match(r, c, cur+1) {
				return true
			}
		}
		return false
	}

	for row, set := range board {
		for col := range set {
			if match(row, col, 0) {
				return true
			}
		}
	}
	return false
}
