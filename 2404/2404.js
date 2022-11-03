/**
* @param {number[]} nums
* @return {number}
*/
var mostFrequentEven = function(nums) {
  const evenNumsMap = new Map()
  let maxFrequency = 0
  let maxFrequentNumbers = new Array()
  
  for (const element of nums) {
    if (element % 2 != 0) continue
    if (!evenNumsMap.has(element)) {
      evenNumsMap.set(element, 0)
    }
    let frequency = evenNumsMap.get(element) + 1
    evenNumsMap.set(element, frequency)
    if (maxFrequency < frequency) {
      maxFrequency = frequency
      maxFrequentNumbers.length = 0
    }
    if (maxFrequency == frequency) {
      maxFrequentNumbers.push(element)
    }
  }
  if (maxFrequency == 0) return -1
  return Math.min(...maxFrequentNumbers)
};