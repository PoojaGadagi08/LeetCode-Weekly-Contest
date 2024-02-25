1.Split the Array

  You are given an integer array nums of even length. You have to split the array into two parts nums1 and nums2 such that:

nums1.length == nums2.length == nums.length / 2.
nums1 should contain distinct elements.
nums2 should also contain distinct elements.
Return true if it is possible to split the array, and false otherwise.

 

Example 1:

Input: nums = [1,1,2,2,3,4]
Output: true
Explanation: One of the possible ways to split nums is nums1 = [1,2,3] and nums2 = [1,2,4].
Example 2:

Input: nums = [1,1,1,1]
Output: false
Explanation: The only possible way to split nums is nums1 = [1,1] and nums2 = [1,1]. Both nums1 and nums2 do not contain distinct elements. Therefore, we return false.
 

Constraints:

1 <= nums.length <= 100
nums.length % 2 == 0
1 <= nums[i] <= 100


  class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int n=nums.length;
        HashMap<Integer, Integer> h =new HashMap<>();
        for(int x : nums){
            h.put(x, h.getOrDefault(x, 0)+1);
        }
        
        for(int value : h.values()){
            if(value>2)
                return false;
        }
        
        return true;
    }
}



2.Find the Largest Area of Square Inside Two Rectangles



  There exist n rectangles in a 2D plane. You are given two 0-indexed 2D integer arrays bottomLeft and topRight, both of size n x 2, where bottomLeft[i] and topRight[i] represent the bottom-left and top-right coordinates of the ith rectangle respectively.

You can select a region formed from the intersection of two of the given rectangles. You need to find the largest area of a square that can fit inside this region if you select the region optimally.

Return the largest possible area of a square, or 0 if there do not exist any intersecting regions between the rectangles.

 

Example 1:


Input: bottomLeft = [[1,1],[2,2],[3,1]], topRight = [[3,3],[4,4],[6,6]]
Output: 1
Explanation: A square with side length 1 can fit inside either the intersecting region of rectangle 0 and rectangle 1, or the intersecting region of rectangle 1 and rectangle 2. Hence the largest area is side * side which is 1 * 1 == 1.
It can be shown that a square with a greater side length can not fit inside any intersecting region.
Example 2:


Input: bottomLeft = [[1,1],[2,2],[1,2]], topRight = [[3,3],[4,4],[3,4]]
Output: 1
Explanation: A square with side length 1 can fit inside either the intersecting region of rectangle 0 and rectangle 1, the intersecting region of rectangle 1 and rectangle 2, or the intersection region of all 3 rectangles. Hence the largest area is side * side which is 1 * 1 == 1.
It can be shown that a square with a greater side length can not fit inside any intersecting region.
Note that the region can be formed by the intersection of more than 2 rectangles.
Example 3:


Input: bottomLeft = [[1,1],[3,3],[3,1]], topRight = [[2,2],[4,4],[4,2]]
Output: 0
Explanation: No pair of rectangles intersect, hence, we return 0.
 

Constraints:

n == bottomLeft.length == topRight.length
2 <= n <= 103
bottomLeft[i].length == topRight[i].length == 2
1 <= bottomLeft[i][0], bottomLeft[i][1] <= 107
1 <= topRight[i][0], topRight[i][1] <= 107
bottomLeft[i][0] < topRight[i][0]
bottomLeft[i][1] < topRight[i][1]



  
class Solution:
    def largestSquareArea(self, b: List[List[int]], t: List[List[int]]) -> int:
        maxi=0;
        intersected=False;
        
        for i in range(len(b)):
            for j in range(i+1, len(b)):
                x1=max(b[i][0], b[j][0]);
                y1=max(b[i][1], b[j][1]);
                x2=max(t[i][0], t[j][0]);
                y2=max(t[i][1], t[j][1]);
                if x1<x2 and y1<y2:
                    intersected = True
                    s = min(x2-x1, y2-y1)
                    maxi=max(maxi, s*s)
        if not intersected:
            return 0;
        
        return max;
