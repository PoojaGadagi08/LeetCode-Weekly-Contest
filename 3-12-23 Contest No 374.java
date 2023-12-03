1.Find the Peaks

  You are given a 0-indexed array mountain. Your task is to find all the peaks in the mountain array.

Return an array that consists of indices of peaks in the given array in any order.

Notes:

A peak is defined as an element that is strictly greater than its neighboring elements.
The first and last elements of the array are not a peak.
 

Example 1:

Input: mountain = [2,4,4]
Output: []
Explanation: mountain[0] and mountain[2] can not be a peak because they are first and last elements of the array.
mountain[1] also can not be a peak because it is not strictly greater than mountain[2].
So the answer is [].
Example 2:

Input: mountain = [1,4,3,8,5]
Output: [1,3]
Explanation: mountain[0] and mountain[4] can not be a peak because they are first and last elements of the array.
mountain[2] also can not be a peak because it is not strictly greater than mountain[3] and mountain[1].
But mountain [1] and mountain[3] are strictly greater than their neighboring elements.
So the answer is [1,3].
 

Constraints:

3 <= mountain.length <= 100
1 <= mountain[i] <= 100



  class Solution {
    public List<Integer> findPeaks(int[] m) {
        List<Integer> ans=new ArrayList<>();
        int n=m.length;
        
        for(int i=1;i<n-1;i++){
            if(m[i]>m[i-1] && m[i]>m[i+1])
                ans.add(i);
        }
        
        return ans;
    }
}



2.Minimum Number of Coins to be Added

  You are given a 0-indexed integer array coins, representing the values of the coins available, and an integer target.

An integer x is obtainable if there exists a subsequence of coins that sums to x.

Return the minimum number of coins of any value that need to be added to the array so that every integer in the range [1, target] is obtainable.

A subsequence of an array is a new non-empty array that is formed from the original array by deleting some (possibly none) of the elements without disturbing the relative positions of the remaining elements.

 

Example 1:

Input: coins = [1,4,10], target = 19
Output: 2
Explanation: We need to add coins 2 and 8. The resulting array will be [1,2,4,8,10].
It can be shown that all integers from 1 to 19 are obtainable from the resulting array, and that 2 is the minimum number of coins that need to be added to the array. 
Example 2:

Input: coins = [1,4,10,5,7,19], target = 19
Output: 1
Explanation: We only need to add the coin 2. The resulting array will be [1,2,4,5,7,10,19].
It can be shown that all integers from 1 to 19 are obtainable from the resulting array, and that 1 is the minimum number of coins that need to be added to the array. 
Example 3:

Input: coins = [1,1,1], target = 20
Output: 3
Explanation: We need to add coins 4, 8, and 16. The resulting array will be [1,1,1,4,8,16].
It can be shown that all integers from 1 to 20 are obtainable from the resulting array, and that 3 is the minimum number of coins that need to be added to the array.
 

Constraints:

1 <= target <= 105
1 <= coins.length <= 105
1 <= coins[i] <= target




  class Solution:
    def minimumAddedCoins(self, coins: List[int], target: int) -> int:
        coins.sort()
        max_reachable = 0
        coins_to_add = 0

        for coin in coins:
            while max_reachable < target and max_reachable + 1 < coin:
                max_reachable += max_reachable + 1
                coins_to_add += 1

            if max_reachable >= target:
                break

            max_reachable += coin

        while max_reachable < target:
            max_reachable += max_reachable + 1
            coins_to_add += 1

        return coins_to_add




  3.Count Complete Substrings

  You are given a string word and an integer k.

A substring s of word is complete if:

Each character in s occurs exactly k times.
The difference between two adjacent characters is at most 2. That is, for any two adjacent characters c1 and c2 in s, the absolute difference in their positions in the alphabet is at most 2.
Return the number of complete substrings of word.

A substring is a non-empty contiguous sequence of characters in a string.

 

Example 1:

Input: word = "igigee", k = 2
Output: 3
Explanation: The complete substrings where each character appears exactly twice and the difference between adjacent characters is at most 2 are: igigee, igigee, igigee.
Example 2:

Input: word = "aaabbbccc", k = 3
Output: 6
Explanation: The complete substrings where each character appears exactly three times and the difference between adjacent characters is at most 2 are: aaabbbccc, aaabbbccc, aaabbbccc, aaabbbccc, aaabbbccc, aaabbbccc.
 

Constraints:

1 <= word.length <= 105
word consists only of lowercase English letters.
1 <= k <= word.length
