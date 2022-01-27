package dfs

// leetcode-0341 2021/3/23

type NestedInteger struct {
}

func (this NestedInteger) IsInteger() bool           { return true }
func (this NestedInteger) GetInteger() int           { return 0 }
func (this NestedInteger) GetList() []*NestedInteger { return nil }

type NestedIterator struct {
	list []*NestedInteger
}

func Constructor(nestedList []*NestedInteger) *NestedIterator {
	return &NestedIterator{nestedList}
}

func (it *NestedIterator) Next() (num int) {
	num = it.list[0].GetInteger()
	it.list = it.list[1:]
	return num
}

func (it *NestedIterator) HasNext() bool {
	for len(it.list) != 0 && !it.list[0].IsInteger() {
		subList := it.list[0].GetList()
		it.list = it.list[1:]
		for i := len(subList) - 1; i >= 0; i-- {
			it.list = append([]*NestedInteger{subList[i]}, it.list...)
		}
	}
	return len(it.list) != 0
}
