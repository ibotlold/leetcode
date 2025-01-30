package main

import (
	"cmp"
	"container/heap"
	"slices"
)

// 1046. Last Stone Weight
// https://leetcode.com/problems/last-stone-weight/

func main() {
	// lastStoneWeight([]int{2, 7, 4, 1, 8, 1})
	lastStoneWeight([]int{2, 2})
}

type MaxHeap []int

func (h MaxHeap) Len() int {
	return len(h)
}

func (h MaxHeap) Less(i, j int) bool {
	return h[i] > h[j]
}

func (h MaxHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *MaxHeap) Push(x any) {
	*h = append(*h, x.(int))
}

func (h *MaxHeap) Pop() any {
	heap := *h
	el := heap[len(heap)-1]
	*h = heap[:len(heap)-1]
	return el
}

func lastStoneWeight(stones []int) int {
	slices.SortFunc(stones, func(a, b int) int {
		return cmp.Compare(b, a)
	})
	var h MaxHeap
	heap.Init(&h)
	for _, v := range stones {
		heap.Push(&h, v)
	}
	hand := make([]int, 2)
	for h.Len() > 1 {
		for i := 0; i < len(hand); i++ {
			hand[i] = heap.Pop(&h).(int)
		}
		maxVal := max(hand[0], hand[1])
		minVal := min(hand[0], hand[1])
		if maxVal > minVal {
			heap.Push(&h, maxVal-minVal)
		}
	}

	if len(h) == 0 {
		return 0
	}
	return heap.Pop(&h).(int)
}
