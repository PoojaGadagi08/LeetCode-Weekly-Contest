1.Find Missing and Repeated Values

  You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

 

Example 1:

Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].
Example 2:

Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
Output: [9,5]
Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].
 

Constraints:

2 <= n == grid.length == grid[i].length <= 50
1 <= grid[i][j] <= n * n
For all x that 1 <= x <= n * n there is exactly one x that is not equal to any of the grid members.
For all x that 1 <= x <= n * n there is exactly one x that is equal to exactly two of the grid members.
For all x that 1 <= x <= n * n except two of them there is exatly one pair of i, j that 0 <= i, j <= n - 1 and grid[i][j] == x.


  class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int ans[]=new int[2];
        int n=grid.length;
         HashSet<Integer> set = new HashSet<>();

        for (int[] row : grid) {
            for (int num : row) {
                // If the number is already in the set, it's a repetition
                if (!set.add(num)) {
                    ans[0]=num;
                }
            }
        }
        
        //Missing value
        for (int i = 1; i <= n*n; i++) {
            if (!set.contains(i)) {
              ans[1]=i;
               
            }
        }
        
        return ans;

    }
}


2.Divide Array Into Arrays With Max Difference

  You are given an integer array nums of size n and a positive integer k.

Divide the array into one or more arrays of size 3 satisfying the following conditions:

Each element of nums should be in exactly one array.
The difference between any two elements in one array is less than or equal to k.
Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.

 

Example 1:

Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
Output: [[1,1,3],[3,4,5],[7,8,9]]
Explanation: We can divide the array into the following arrays: [1,1,3], [3,4,5] and [7,8,9].
The difference between any two elements in each array is less than or equal to 2.
Note that the order of elements is not important.
Example 2:

Input: nums = [1,3,3,2,7,3], k = 3
Output: []
Explanation: It is not possible to divide the array satisfying all the conditions.
 

Constraints:

n == nums.length
1 <= n <= 105
n is a multiple of 3.
1 <= nums[i] <= 105
1 <= k <= 105


  class Solution {
    public int[][] divideArray(int[] nums, int k) {
//            Arrays.sort(nums);

//     int n = nums.length;
//     int[][] result = new int[n / 3][3];
//     int resultIndex = 0;

//     int start = 0;

//     while (start < n) {
//         int end = start + 2;
//         if (end >= n) {
//             // If there are less than 3 elements remaining, it's not possible
//             return new int[0][0];
//         }

//         if (nums[end] - nums[start] <= k) {
//             // Add the subarray to the result
//             for (int i = start, j = 0; i <= end; i++, j++) {
//                 result[resultIndex][j] = nums[i];
//             }
//             resultIndex++;

//             // Move to the next starting point
//             start = end + 1;
//         } else {
//             // Move to the next starting point
//             start++;
//         }
//     }

//     return result;
        
        
        
        
        
        
        
        int n = nums.length;
        Arrays.sort(nums);

        int[][] result = new int[n / 3][3];
        int resultIndex = 0;

        for (int i = 0; i < n; i += 3) {
            if (i + 2 < n && nums[i + 2] - nums[i] <= k) {
                result[resultIndex++] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
            } else {
                return new int[0][0];
            }
        }

        return result;

    }
}

3.Minimum Cost to Make Array Equalindromic

  You are given a 0-indexed integer array nums having length n.

You are allowed to perform a special move any number of times (including zero) on nums. In one special move you perform the following steps in order:

Choose an index i in the range [0, n - 1], and a positive integer x.
Add |nums[i] - x| to the total cost.
Change the value of nums[i] to x.
A palindromic number is a positive integer that remains the same when its digits are reversed. For example, 121, 2552 and 65756 are palindromic numbers whereas 24, 46, 235 are not palindromic numbers.

An array is considered equalindromic if all the elements in the array are equal to an integer y, where y is a palindromic number less than 109.

Return an integer denoting the minimum possible total cost to make nums equalindromic by performing any number of special moves.

 

Example 1:

Input: nums = [1,2,3,4,5]
Output: 6
Explanation: We can make the array equalindromic by changing all elements to 3 which is a palindromic number. The cost of changing the array to [3,3,3,3,3] using 4 special moves is given by |1 - 3| + |2 - 3| + |4 - 3| + |5 - 3| = 6.
It can be shown that changing all elements to any palindromic number other than 3 cannot be achieved at a lower cost.
Example 2:

Input: nums = [10,12,13,14,15]
Output: 11
Explanation: We can make the array equalindromic by changing all elements to 11 which is a palindromic number. The cost of changing the array to [11,11,11,11,11] using 5 special moves is given by |10 - 11| + |12 - 11| + |13 - 11| + |14 - 11| + |15 - 11| = 11.
It can be shown that changing all elements to any palindromic number other than 11 cannot be achieved at a lower cost.
Example 3:

Input: nums = [22,33,22,33,22]
Output: 22
Explanation: We can make the array equalindromic by changing all elements to 22 which is a palindromic number. The cost of changing the array to [22,22,22,22,22] using 2 special moves is given by |33 - 22| + |33 - 22| = 22.
It can be shown that changing all elements to any palindromic number other than 22 cannot be achieved at a lower cost.
 

Constraints:

1 <= n <= 105
1 <= nums[i] <= 109


  class Solution:
    def minimumCost(self, nums: List[int]) -> int:
        def is_palindrome(x):
            original, reverse = x, 0
            while x > 0:
                digit = x % 10
                reverse = reverse * 10 + digit
                x = x // 10
            return original == reverse

        nums.sort()
        n = len(nums)

        median = nums[n // 2]
        if is_palindrome(median):
            total_cost = sum(abs(num - median) for num in nums)
        else:
            total_cost = float('inf')
            for i in range(nums[0], nums[-1] + 1):
                if is_palindrome(i):
                    total_cost = min(total_cost, sum(abs(num - i) for num in nums))

            if total_cost == float('inf'):
                total_cost = sum(abs(num - median) for num in nums)

        return total_cost

