package medium

// leetcode-0990 2021/3/27

func union(parent []int, id1, id2 int) {
	parent[find(parent, id1)] = find(parent, id2)
}

func find(parent []int, id int) int {
	for parent[id] != id {
		parent[id] = parent[parent[id]]
		id = parent[id]
	}
	return id
}

func connected(parent []int, id1, id2 int) bool {
	return find(parent, id1) == find(parent, id2)
}

func equationsPossible(equations []string) bool {
	parent := make([]int, 26)
	for i := 0; i < 26; i++ {
		parent[i] = i
	}
	for i := 0; i < len(equations); i++ {
		if equations[i][1] == '=' {
			union(parent, int(equations[i][0]-'a'), int(equations[i][3]-'a'))
		}
	}
	for i := 0; i < len(equations); i++ {
		if equations[i][1] == '!' {
			if connected(parent, int(equations[i][0]-'a'), int(equations[i][3]-'a')) {
				return false
			}
		}
	}
	return true
}
