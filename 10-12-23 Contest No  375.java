1.Count Tested Devices After Test Operations



  You are given a 0-indexed integer array batteryPercentages having length n, denoting the battery percentages of n 0-indexed devices.

Your task is to test each device i in order from 0 to n - 1, by performing the following test operations:

If batteryPercentages[i] is greater than 0:
Increment the count of tested devices.
Decrease the battery percentage of all devices with indices j in the range [i + 1, n - 1] by 1, ensuring their battery percentage never goes below 0, i.e, batteryPercentages[j] = max(0, batteryPercentages[j] - 1).
Move to the next device.
Otherwise, move to the next device without performing any test.
Return an integer denoting the number of devices that will be tested after performing the test operations in order.

 

Example 1:

Input: batteryPercentages = [1,1,2,1,3]
Output: 3
Explanation: Performing the test operations in order starting from device 0:
At device 0, batteryPercentages[0] > 0, so there is now 1 tested device, and batteryPercentages becomes [1,0,1,0,2].
At device 1, batteryPercentages[1] == 0, so we move to the next device without testing.
At device 2, batteryPercentages[2] > 0, so there are now 2 tested devices, and batteryPercentages becomes [1,0,1,0,1].
At device 3, batteryPercentages[3] == 0, so we move to the next device without testing.
At device 4, batteryPercentages[4] > 0, so there are now 3 tested devices, and batteryPercentages stays the same.
So, the answer is 3.
Example 2:

Input: batteryPercentages = [0,1,2]
Output: 2
Explanation: Performing the test operations in order starting from device 0:
At device 0, batteryPercentages[0] == 0, so we move to the next device without testing.
At device 1, batteryPercentages[1] > 0, so there is now 1 tested device, and batteryPercentages becomes [0,1,1].
At device 2, batteryPercentages[2] > 0, so there are now 2 tested devices, and batteryPercentages stays the same.
So, the answer is 2.
 

Constraints:

1 <= n == batteryPercentages.length <= 100
0 <= batteryPercentages[i] <= 100



  class Solution {
    public int countTestedDevices(int[] b) {
         int n = b.length;
        int testedDev = 0;
        
        for (int i = 0; i < n; i++) {
            if (b[i] > 0) {
                testedDev++;
                for (int j = i + 1; j < n; j++) {
                    if (b[j] > 0) {
                        b[j] = Math.max(0, b[j] - 1);
                    }
                }
            }
        }
        
        return testedDev;
    }
}



2.Double Modular Exponentiation


  You are given a 0-indexed 2D array variables where variables[i] = [ai, bi, ci, mi], and an integer target.

An index i is good if the following formula holds:

0 <= i < variables.length
((aibi % 10)ci) % mi == target
Return an array consisting of good indices in any order.

 

Example 1:

Input: variables = [[2,3,3,10],[3,3,3,1],[6,1,1,4]], target = 2
Output: [0,2]
Explanation: For each index i in the variables array:
1) For the index 0, variables[0] = [2,3,3,10], (23 % 10)3 % 10 = 2.
2) For the index 1, variables[1] = [3,3,3,1], (33 % 10)3 % 1 = 0.
3) For the index 2, variables[2] = [6,1,1,4], (61 % 10)1 % 4 = 2.
Therefore we return [0,2] as the answer.
Example 2:

Input: variables = [[39,3,1000,1000]], target = 17
Output: []
Explanation: For each index i in the variables array:
1) For the index 0, variables[0] = [39,3,1000,1000], (393 % 10)1000 % 1000 = 1.
Therefore we return [] as the answer.
 

Constraints:

1 <= variables.length <= 100
variables[i] == [ai, bi, ci, mi]
1 <= ai, bi, ci, mi <= 103
0 <= target <= 103




  class Solution {
public:
    vector<int> getGoodIndices(vector<vector<int>>& variables, int target) {
        vector<int> ans;
        int k=0;
        for (auto x : variables) {
            int a = x[0], b = x[1], c = x[2], d = x[3];

            int n1 = 1;
            for (int i = 0; i < b; ++i) {
                n1 = (n1 * a) % 10;
            }

            int n2 = 1;
            for (int i = 0; i < c; ++i) {
                n2 = (n2 * n1) % d;
            }

            if (n2 == target) {
                ans.push_back(k);
            }

            k++;
        }

        return ans;
    }
};




3.Count Subarrays Where Max Element Appears at Least K Times

  You are given an integer array nums and a positive integer k.

Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

A subarray is a contiguous sequence of elements within an array.

 

Example 1:

Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
Example 2:

Input: nums = [1,4,2,1], k = 3
Output: 0
Explanation: No subarray contains the element 4 at least 3 times.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 106
1 <= k <= 105



  class Solution {
public:
    long long countSubarrays(vector<int>& nums, int k) {
        long long  n = nums.size(); 
        long long  m = *max_element(nums.begin(), nums.end()); 
        long long i = 0, j = 0, cnt = 0, ans = 0; 
        while (j < n) { 
            if (nums[j] == m) { 
                cnt++; 
            } 
            if (cnt >= k) { 
                while (cnt >= k) { 
                    ans += n - j; 
                    if (nums[i] == m) { 
                        cnt--; 
                    } 
                    i++; 
                } 
            } 
            j++; 
        } 
        return ans; 
    }
};

