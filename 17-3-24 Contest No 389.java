1.Existence of a Substring in a String and Its Reverse

  Given a string s, find any substring of length 2 which is also present in the reverse of s.

Return true if such a substring exists, and false otherwise.

 

Example 1:

Input: s = "leetcode"

Output: true

Explanation: Substring "ee" is of length 2 which is also present in reverse(s) == "edocteel".

Example 2:

Input: s = "abcba"

Output: true

Explanation: All of the substrings of length 2 "ab", "bc", "cb", "ba" are also present in reverse(s) == "abcba".

Example 3:

Input: s = "abcd"

Output: false

Explanation: There is no substring of length 2 in s, which is also present in the reverse of s.

 

Constraints:

1 <= s.length <= 100
s consists only of lowercase English letters.


  class Solution {
    public boolean isSubstringPresent(String s) {
           // Iterate through the string
        for (int i = 0; i < s.length() - 1; i++) {
            // Get a substring of length 2
            String sub = s.substring(i, i + 2);
            // Reverse the substring
            String reverseSub = new StringBuilder(sub).reverse().toString();
            // Check if the reverse substring exists in the original string
            if (s.contains(reverseSub)) {
                return true;
            }
        }
        return false;
    }
}


2. Count Substrings Starting and Ending with Given Character


  You are given a string s and a character c. Return the total number of substrings of s that start and end with c.

 

Example 1:

Input: s = "abada", c = "a"

Output: 6

Explanation: Substrings starting and ending with "a" are: "abada", "abada", "abada", "abada", "abada", "abada".

Example 2:

Input: s = "zzz", c = "z"

Output: 6

Explanation: There are a total of 6 substrings in s and all start and end with "z".

 

Constraints:

1 <= s.length <= 105
s and c consist only of lowercase English letters.


  class Solution:
    def countSubstrings(self, s: str, c: str) -> int:
        cnt = 0
        c_cnt = s.count(c)
        if c_cnt == 0:
            return 0
        cnt = c_cnt * (c_cnt + 1) // 2
        return cnt

sol = Solution()
# Example usage:
# print(sol.countSubstrings("abccba", "c"))  # Output: 6



  3.Minimum Deletions to Make String K-Special


  You are given a string word and an integer k.

We consider word to be k-special if |freq(word[i]) - freq(word[j])| <= k for all indices i and j in the string.

Here, freq(x) denotes the frequency of the character x in word, and |y| denotes the absolute value of y.

Return the minimum number of characters you need to delete to make word k-special.

 

Example 1:

Input: word = "aabcaba", k = 0

Output: 3

Explanation: We can make word 0-special by deleting 2 occurrences of "a" and 1 occurrence of "c". Therefore, word becomes equal to "baba" where freq('a') == freq('b') == 2.

Example 2:

Input: word = "dabdcbdcdcd", k = 2

Output: 2

Explanation: We can make word 2-special by deleting 1 occurrence of "a" and 1 occurrence of "d". Therefore, word becomes equal to "bdcbdcdcd" where freq('b') == 2, freq('c') == 3, and freq('d') == 4.

Example 3:

Input: word = "aaabaaa", k = 2

Output: 1

Explanation: We can make word 2-special by deleting 1 occurrence of "b". Therefore, word becomes equal to "aaaaaa" where each letter's frequency is now uniformly 6.

 

Constraints:

1 <= word.length <= 105
0 <= k <= 105
word consists only of lowercase English letters.




  class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        freq = {}
        for char in word:
            freq[char] = freq.get(char, 0) + 1
            
        # Extract the frequencies and sort them in descending order.
        frequencies = sorted(freq.values(), reverse=True)
        
        # Initialize variables for the minimum deletions and the target frequency list.
        min_deletions = float('inf')
        
        # Iterate over the possible target frequencies.
        for i in range(len(frequencies)):
            target = frequencies[i]
            deletions = 0
            # For each target, compute the deletions needed for all other frequencies.
            for f in frequencies:
                if f > target + k:
                    deletions += f - (target + k)
                elif f < target:
                    deletions += f
            # Keep track of the minimum deletions found so far.
            min_deletions = min(min_deletions, deletions)
            
            if min_deletions == 0:  # Early exit if no deletions needed.
                break
            
        return min_deletions if min_deletions != float('inf') else 0

# Test cases
solution = Solution()
