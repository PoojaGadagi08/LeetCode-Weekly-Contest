1.

You are given 2 integer arrays nums1 and nums2 of lengths n and m respectively. You are also given a positive integer k.

A pair (i, j) is called good if nums1[i] is divisible by nums2[j] * k (0 <= i <= n - 1, 0 <= j <= m - 1).

Return the total number of good pairs.

 

Example 1:

Input: nums1 = [1,3,4], nums2 = [1,3,4], k = 1

Output: 5

Explanation:

The 5 good pairs are (0, 0), (1, 0), (1, 1), (2, 0), and (2, 2).
Example 2:

Input: nums1 = [1,2,4,12], nums2 = [2,4], k = 3

Output: 2

Explanation:

The 2 good pairs are (3, 0) and (3, 1).

 

Constraints:

1 <= n, m <= 50
1 <= nums1[i], nums2[j] <= 50
1 <= k <= 50

  
class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
         int cnt = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] % (nums2[j] * k) == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}


2.
  Given a string word, compress it using the following algorithm:

Begin with an empty string comp. While word is not empty, use the following operation:
<ul>
	<li>Remove a maximum length prefix of <code>word</code> made of a <em>single character</em> <code>c</code> repeating <strong>at most</strong> 9 times.</li>
	<li>Append the length of the prefix followed by <code>c</code> to <code>comp</code>.</li>
</ul>
</li>
Return the string comp.

 

 

Example 1:

Input: word = "abcde"

Output: "1a1b1c1d1e"

Explanation:

Initially, comp = "". Apply the operation 5 times, choosing "a", "b", "c", "d", and "e" as the prefix in each operation.

For each prefix, append "1" followed by the character to comp.

Example 2:

Input: word = "aaaaaaaaaaaaaabb"

Output: "9a5a2b"

Explanation:

Initially, comp = "". Apply the operation 3 times, choosing "aaaaaaaaa", "aaaaa", and "bb" as the prefix in each operation.

For prefix "aaaaaaaaa", append "9" followed by "a" to comp.
For prefix "aaaaa", append "5" followed by "a" to comp.
For prefix "bb", append "2" followed by "b" to comp.
 

Constraints:

1 <= word.length <= 2 * 105
word consists only of lowercase English letters.

  
  class Solution {
    public String compressedString(String word) {
         StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 0; i < word.length(); i++) {
            
            if (i + 1 < word.length() && word.charAt(i) == word.charAt(i + 1)) {
                count++;
            } else {
                
            sb.append(count).append(word.charAt(i));
                
                count = 1;
            }
            if (count == 10) {
                sb.append(9).append(word.charAt(i));
                count = 1;
            }
        }

        return sb.toString();
    }
}


3.
  You are given 2 integer arrays nums1 and nums2 of lengths n and m respectively. You are also given a positive integer k.

A pair (i, j) is called good if nums1[i] is divisible by nums2[j] * k (0 <= i <= n - 1, 0 <= j <= m - 1).

Return the total number of good pairs.

 

Example 1:

Input: nums1 = [1,3,4], nums2 = [1,3,4], k = 1

Output: 5

Explanation:

The 5 good pairs are (0, 0), (1, 0), (1, 1), (2, 0), and (2, 2).
Example 2:

Input: nums1 = [1,2,4,12], nums2 = [2,4], k = 3

Output: 2

Explanation:

The 2 good pairs are (3, 0) and (3, 1).

 

Constraints:

1 <= n, m <= 105
1 <= nums1[i], nums2[j] <= 106
1 <= k <= 103

  class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
          
     
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int num : nums2) {
            m.put(num * k, m.getOrDefault(num * k, 0) + 1);
        }

        long cnt = 0;
       
        for (int num : nums1) {
          
           for(int i=1;i<=Math.sqrt(num);i++){


            if(num%i ==0 ){
                int a =num/i;
                
                if(m.containsKey(i)){
                    cnt+=m.get(i);
                }


                if(a != i && m.containsKey(a)){
                    cnt+=m.get(a);
                }


            }
           }
        }

        return cnt;
    }
}



You are given an array nums consisting of integers. You are also given a 2D array queries, where queries[i] = [posi, xi].

For query i, we first set nums[posi] equal to xi, then we calculate the answer to query i which is the maximum sum of a 
subsequence
 of nums where no two adjacent elements are selected.

Return the sum of the answers to all queries.

Since the final answer may be very large, return it modulo 109 + 7.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [3,5,9], queries = [[1,-2],[0,-3]]

Output: 21

Explanation:
After the 1st query, nums = [3,-2,9] and the maximum sum of a subsequence with non-adjacent elements is 3 + 9 = 12.
After the 2nd query, nums = [-3,-2,9] and the maximum sum of a subsequence with non-adjacent elements is 9.

Example 2:

Input: nums = [0,-1], queries = [[0,-5]]

Output: 0

Explanation:
After the 1st query, nums = [-5,-1] and the maximum sum of a subsequence with non-adjacent elements is 0 (choosing an empty subsequence).

 

Constraints:

1 <= nums.length <= 5 * 104
-105 <= nums[i] <= 105
1 <= queries.length <= 5 * 104
queries[i] == [posi, xi]
0 <= posi <= nums.length - 1
-105 <= xi <= 105
4.
  
  class Solution {
    public int maximumSumSubsequence(int[] nums, int[][] q) {
        final int m = 1_000_000_007;
        int n = nums.length;

        long[] i = new long[n];
        long[] e = new long[n];

        i[0] = Math.max(0, nums[0]);
        e[0] = 0;

        for (int j = 1; j < n; j++) {
            i[j] = Math.max(0, nums[j] + e[j - 1]);
            e[j] = Math.max(i[j - 1], e[j - 1]);
        }

        long maxSum = Math.max(i[n - 1], e[n - 1]);
        long totalSum = 0;

        for (int[] query : q) {
            int p = query[0];
            int newVal = query[1];
            
            nums[p] = newVal;

            if (p == 0) {
                i[0] = Math.max(0, nums[0]);
                e[0] = 0;
            }

            for (int a = Math.max(1, p); a < n; a++) {
                if (a == p) {
                    i[a] = Math.max(0, nums[a] + (a  > 0 ? e[a - 1] : 0));
                } else {
                    i[a] = Math.max(0, nums[a] + e[a - 1]);
                }
                e[a] = Math.max(i[a - 1], e[a - 1]);
            }
            maxSum = Math.max(i[n - 1], e[n - 1]);
            totalSum = (totalSum + maxSum) % m;
        }
        return (int) totalSum;
    }
}
