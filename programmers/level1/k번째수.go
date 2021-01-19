import "sort"

func solution(array []int, commands [][]int) []int {
	var result []int
	for _, command := range commands {
		slice := append([]int{}, array[command[0]-1:command[1]]...)
		sort.Ints(slice)
		result = append(result, slice[command[2]-1])
	}
	return result
}