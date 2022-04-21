package dp

// leetcode-0931 2022/4/21

func minFallingPathSum(matrix [][]int) int {
	for i := len(matrix) - 2; i >= 0; i-- {
		for j := 0; j < len(matrix[i]); j++ {
			down := matrix[i+1][j]
			if j != 0 {
				down = min(down, matrix[i+1][j-1])
			}
			if j != len(matrix[i])-1 {
				down = min(down, matrix[i+1][j+1])
			}
			matrix[i][j] += down
		}
	}
	return min(matrix[0]...)
}
