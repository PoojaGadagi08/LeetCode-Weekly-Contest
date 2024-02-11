1.Modify the Matrix

  Given a 0-indexed m x n integer matrix matrix, create a new 0-indexed matrix called answer. Make answer equal to matrix, then replace each element with the value -1 with the maximum element in its respective column.

Return the matrix answer.

 

Example 1:


Input: matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
Output: [[1,2,9],[4,8,6],[7,8,9]]
Explanation: The diagram above shows the elements that are changed (in blue).
- We replace the value in the cell [1][1] with the maximum value in the column 1, that is 8.
- We replace the value in the cell [0][2] with the maximum value in the column 2, that is 9.
Example 2:


Input: matrix = [[3,-1],[5,2]]
Output: [[3,2],[5,2]]
Explanation: The diagram above shows the elements that are changed (in blue).
 

Constraints:

m == matrix.length
n == matrix[i].length
2 <= m, n <= 50
-1 <= matrix[i][j] <= 100
The input is generated such that each column contains at least one non-negative integer.


  class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        
        
        int ans[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==-1)
                    ans[i][j]=max(matrix, j);
                else 
                    ans[i][j]=matrix[i][j];
            }
        }
        return ans;
    }
    
    public int max(int[][] matrix, int columnIndex ){
        int maxInColumn = matrix[0][columnIndex];

        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][columnIndex] > maxInColumn) {
                maxInColumn = matrix[row][columnIndex];
            }
        }

        return maxInColumn;

    }
}

2. Number of Subarrays That Match a Pattern I

  You are given a 0-indexed integer array nums of size n, and a 0-indexed integer array pattern of size m consisting of integers -1, 0, and 1.

A subarray nums[i..j] of size m + 1 is said to match the pattern if the following conditions hold for each element pattern[k]:

nums[i + k + 1] > nums[i + k] if pattern[k] == 1.
nums[i + k + 1] == nums[i + k] if pattern[k] == 0.
nums[i + k + 1] < nums[i + k] if pattern[k] == -1.
Return the count of subarrays in nums that match the pattern.

 

Example 1:

Input: nums = [1,2,3,4,5,6], pattern = [1,1]
Output: 4
Explanation: The pattern [1,1] indicates that we are looking for strictly increasing subarrays of size 3. In the array nums, the subarrays [1,2,3], [2,3,4], [3,4,5], and [4,5,6] match this pattern.
Hence, there are 4 subarrays in nums that match the pattern.
Example 2:

Input: nums = [1,4,4,1,3,5,5,3], pattern = [1,0,-1]
Output: 2
Explanation: Here, the pattern [1,0,-1] indicates that we are looking for a sequence where the first number is smaller than the second, the second is equal to the third, and the third is greater than the fourth. In the array nums, the subarrays [1,4,4,1], and [3,5,5,3] match this pattern.
Hence, there are 2 subarrays in nums that match the pattern.
 

Constraints:

2 <= n == nums.length <= 100
1 <= nums[i] <= 109
1 <= m == pattern.length < n
-1 <= pattern[i] <= 1


  class Solution {
    public int countMatchingSubarrays(int[] nums, int[] p) {
        
        int n=nums.length;
        int m = p.length;
        
        int cnt=0;
        
        for(int i=0;i<n-m;i++){
            boolean valid=true;
            
            for(int j=0;j<m;j++){
                if(p[j] == 1 && nums[i+j+1] <= nums[i+j]){
                    valid  = false;
                break;
                }
                else if(p[j] == 0 && nums[i+j+1] != nums[i+j]){
                    valid = false;
                    break;
                }
                else if(p[j] == -1 && nums[i+j+1] >= nums[i+j]){
                    valid = false;
                    break;
                }
            }
            
            if(valid)
                cnt++;
        }
        
        return cnt;
    }
}



3.Maximum Palindromes After Operations

  You are given a 0-indexed string array words having length n and containing 0-indexed strings.

You are allowed to perform the following operation any number of times (including zero):

Choose integers i, j, x, and y such that 0 <= i, j < n, 0 <= x < words[i].length, 0 <= y < words[j].length, and swap the characters words[i][x] and words[j][y].
Return an integer denoting the maximum number of palindromes words can contain, after performing some operations.

Note: i and j may be equal during an operation.

 

Example 1:

Input: words = ["abbb","ba","aa"]
Output: 3
Explanation: In this example, one way to get the maximum number of palindromes is:
Choose i = 0, j = 1, x = 0, y = 0, so we swap words[0][0] and words[1][0]. words becomes ["bbbb","aa","aa"].
All strings in words are now palindromes.
Hence, the maximum number of palindromes achievable is 3.
Example 2:

Input: words = ["abc","ab"]
Output: 2
Explanation: In this example, one way to get the maximum number of palindromes is: 
Choose i = 0, j = 1, x = 1, y = 0, so we swap words[0][1] and words[1][0]. words becomes ["aac","bb"].
Choose i = 0, j = 0, x = 1, y = 2, so we swap words[0][1] and words[0][2]. words becomes ["aca","bb"].
Both strings are now palindromes.
Hence, the maximum number of palindromes achievable is 2.
Example 3:

Input: words = ["cd","ef","a"]
Output: 1
Explanation: In this example, there is no need to perform any operation.
There is one palindrome in words "a".
It can be shown that it is not possible to get more than one palindrome after any number of operations.
Hence, the answer is 1.
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 100
words[i] consists only of lowercase English letters.
