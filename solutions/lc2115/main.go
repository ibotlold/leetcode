package main

// 2115. Find All Possible Recipes from Given Supplies
// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/

func findAllRecipes(recipes []string, ingredients [][]string, supplies []string) []string {
	inputs := make(map[string]int)
	graph := make(map[string][]string)

	for i, recipe := range recipes {
		inputs[recipe] = len(ingredients[i])
		for _, ingredient := range ingredients[i] {
			list := graph[ingredient]
			list = append(list, recipe)
			graph[ingredient] = list
		}
	}

	var result []string

	for len(supplies) > 0 {
		supply := supplies[0]
		supplies = supplies[1:]
		recipes := graph[supply]
		for _, recipe := range recipes {
			inputs[recipe] -= 1
			if inputs[recipe] == 0 {
				supplies = append(supplies, recipe)
				result = append(result, recipe)
			}
		}
	}

	return result
}
