package medium

// leetcode-0130 2021/3/26

func solve(board [][]byte)  {
	r,c := len(board),len(board[0])

	if r==0 || c==0 {
		return
	}

	//定义dfs函数
	var dfs func(board [][]byte,x int,y int)
	dfs = func(board [][]byte, x int, y int) {
		if x < 0 || x >= r || y < 0 || y>=c || board[x][y] != 'O'{
			return
		}
		if board[x][y] == 'O' {
			board[x][y] = '#'
			dfs(board,x,y-1)
			dfs(board,x,y+1)
			dfs(board,x-1,y)
			dfs(board,x+1,y)
		}
	}
	
	for i:=0;i<c;i++ {
		dfs(board,0,i)
		dfs(board,r-1,i)
	}

	for i:=0;i<r;i++ {
		dfs(board,i,0)
		dfs(board,i,c-1)
	}

	for i := 0; i < r; i++ {
		for j := 0; j < c; j++ {
			if board[i][j] == 'O' {
				board[i][j] = 'X'
			}
			if board[i][j] == '#' {
				board[i][j] = 'O'
			}
		}
	}
}
