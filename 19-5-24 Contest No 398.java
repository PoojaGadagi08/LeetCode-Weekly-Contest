Special Array I
An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.

 

Example 1:

Input: nums = [1]

Output: true

Explanation:

There is only one element. So the answer is true.

Example 2:

Input: nums = [2,1,4]

Output: true

Explanation:

There is only two pairs: (2,1) and (1,4), and both of them contain numbers with different parity. So the answer is true.

Example 3:

Input: nums = [4,3,1,6]

Output: false

Explanation:

nums[1] and nums[2] are both odd. So the answer is false.

 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100

Example 1:

Input: nums = [1]

Output: true

Explanation:

There is only one element. So the answer is true.

Example 2:

Input: nums = [2,1,4]

Output: true

Explanation:

There is only two pairs: (2,1) and (1,4), and both of them contain numbers with different parity. So the answer is true.

Example 3:

Input: nums = [4,3,1,6]

Output: false

Explanation:

nums[1] and nums[2] are both odd. So the answer is false.

 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100





  class Solution {
    public boolean isArraySpecial(int[] nums) {
     if(nums.length ==1 )
         return true;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]%2 != 0 && nums[i-1]%2 != 0 )
                return false;
            if(nums[i]%2 == 0 && nums[i-1]%2 == 0 )
                return false;
        }
        return true;
    }
}




2.Special Array II

  An array is considered special if every pair of its adjacent elements contains two numbers with different parity.

You are given an array of integer nums and a 2D integer matrix queries, where for queries[i] = [fromi, toi] your task is to check that subarray nums[fromi..toi] is special or not.

Return an array of booleans answer such that answer[i] is true if nums[fromi..toi] is special.
 

Example 1:

Input: nums = [3,4,1,2,6], queries = [[0,4]]

Output: [false]

Explanation:

The subarray is [3,4,1,2,6]. 2 and 6 are both even.

Example 2:

Input: nums = [4,3,1,6], queries = [[0,2],[2,3]]

Output: [false,true]

Explanation:

The subarray is [4,3,1]. 3 and 1 are both odd. So the answer to this query is false.
The subarray is [1,6]. There is only one pair: (1,6) and it contains numbers with different parity. So the answer to this query is true.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
1 <= queries.length <= 105
queries[i].length == 2
0 <= queries[i][0] <= queries[i][1] <= nums.length - 1

  class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
     // boolean[] ans = new boolean[queries.length];
        
//         int n=nums.length;
//         boolean[] isSpecial = new boolean[n-1];
        
//         for(int i=0;i<n-1;i++){
//             isSpecial[i]=(nums[i] % 2 != nums[i + 1] % 2);
//         }
        
        
//         for(int i=0;i<queries.length;i++){
//             int from=queries[i][0];
//             int to = queries[i][1];
            
//             ans[i]=true;
            
//             for(int j=from;j<to;j++){
//                 if(!isSpecial[j]){
//                     ans[i]=false;
//                     break;
//                 }
//             }
//         }
//         return ans;
        
        
        
        
        //Optimal solution
        
         int n = nums.length;
        int[] prefixParity = new int[n];
        
        // Calculate the prefix sum of parity changes
        for (int i = 1; i < n; i++) {
            prefixParity[i] = prefixParity[i - 1] + (nums[i] % 2 != nums[i - 1] % 2 ? 1 : 0);
        }
        
        boolean[] answer = new boolean[queries.length];
        
        // Answer each query in O(1) time
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            
            if (from == to) {
                answer[i] = true;
            } else {
                answer[i] = (prefixParity[to] - prefixParity[from]) == (to - from);
            }
        }
        
        return answer;
    }
}

3.Sum of Digit Differences of All Pairs

  You are given an array nums consisting of positive integers where all integers have the same number of digits.

The digit difference between two integers is the count of different digits that are in the same position in the two integers.

Return the sum of the digit differences between all pairs of integers in nums.

 

Example 1:

Input: nums = [13,23,12]

Output: 4

Explanation:
We have the following:
- The digit difference between 13 and 23 is 1.
- The digit difference between 13 and 12 is 1.
- The digit difference between 23 and 12 is 2.
So the total sum of digit differences between all pairs of integers is 1 + 1 + 2 = 4.

Example 2:

Input: nums = [10,10,10,10]

Output: 0

Explanation:
All the integers in the array are the same. So the total sum of digit differences between all pairs of integers will be 0.

 

Constraints:

2 <= nums.length <= 105
1 <= nums[i] < 109
All integers in nums have the same number of digits.


  class Solution {
    public long sumDigitDifferences(int[] nums) {
         int n = nums.length;
        int numD = String.valueOf(nums[0]).length();
        
        int[][] digitCounts = new int[numD][10];
        
        for (int num : nums) {
            String numStr = String.valueOf(num);
            for (int i = 0; i < numD; i++) {
                digitCounts[i][numStr.charAt(i) - '0']++;
            }
        }
        
        long sum = 0;
        
        for (int i = 0; i < numD; i++) {
            for (int digit = 0; digit < 10; digit++) {
                int countOfDigit = digitCounts[i][digit];
                if (countOfDigit > 0) {
                    sum += (long) countOfDigit * (n - countOfDigit);
                }
            }
        }
        
        return sum/2;
    }
}

4. Find Number of Ways to Reach the K-th Stair

  You are given a non-negative integer k. There exists a staircase with an infinite number of stairs, with the lowest stair numbered 0.

Alice has an integer jump, with an initial value of 0. She starts on stair 1 and wants to reach stair k using any number of operations. If she is on stair i, in one operation she can:

Go down to stair i - 1. This operation cannot be used consecutively or on stair 0.
Go up to stair i + 2jump. And then, jump becomes jump + 1.
Return the total number of ways Alice can reach stair k.

Note that it is possible that Alice reaches the stair k, and performs some operations to reach the stair k again.

 

Example 1:

Input: k = 0

Output: 2

Explanation:

The 2 possible ways of reaching stair 0 are:

Alice starts at stair 1.
Using an operation of the first type, she goes down 1 stair to reach stair 0.
Alice starts at stair 1.
Using an operation of the first type, she goes down 1 stair to reach stair 0.
Using an operation of the second type, she goes up 20 stairs to reach stair 1.
Using an operation of the first type, she goes down 1 stair to reach stair 0.
Example 2:

Input: k = 1

Output: 4

Explanation:

The 4 possible ways of reaching stair 1 are:

Alice starts at stair 1. Alice is at stair 1.
Alice starts at stair 1.
Using an operation of the first type, she goes down 1 stair to reach stair 0.
Using an operation of the second type, she goes up 20 stairs to reach stair 1.
Alice starts at stair 1.
Using an operation of the second type, she goes up 20 stairs to reach stair 2.
Using an operation of the first type, she goes down 1 stair to reach stair 1.
Alice starts at stair 1.
Using an operation of the first type, she goes down 1 stair to reach stair 0.
Using an operation of the second type, she goes up 20 stairs to reach stair 1.
Using an operation of the first type, she goes down 1 stair to reach stair 0.
Using an operation of the second type, she goes up 21 stairs to reach stair 2.
Using an operation of the first type, she goes down 1 stair to reach stair 1.
 

Constraints:

0 <= k <= 109

  
