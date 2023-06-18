1)Total Distance Traveled

A truck has two fuel tanks. You are given two integers, mainTank representing the fuel present in the main tank in liters and additionalTank representing the fuel
present in the additional tank in liters.

The truck has a mileage of 10 km per liter. Whenever 5 liters of fuel get used up in the main tank, if the additional tank has at least 1 liters of fuel, 1 liters 
of fuel will be transferred from the additional tank to the main tank.

Return the maximum distance which can be traveled.

Note: Injection from the additional tank is not continuous. It happens suddenly and immediately for every 5 liters consumed.

 

Example 1:

Input: mainTank = 5, additionalTank = 10
Output: 60
Explanation: 
After spending 5 litre of fuel, fuel remaining is (5 - 5 + 1) = 1 litre and distance traveled is 50km.
After spending another 1 litre of fuel, no fuel gets injected in the main tank and the main tank becomes empty.
Total distance traveled is 60km.
Example 2:

Input: mainTank = 1, additionalTank = 2
Output: 10
Explanation: 
After spending 1 litre of fuel, the main tank becomes empty.
Total distance traveled is 10km.
  
  class Solution {
    public int distanceTraveled(int m, int a) {
        // if(m>=5)
        //     return (m-5)*10+50+10;
        // else
        //     return m*10;
        
        int ans=0;
        while(true){
            if(m>=5){
                m-=5;
                int mul=5*10;
                ans=ans+mul;
                if(a>0){
                    m++;
                    a--;
                }
            }else break;
        }
        int mul=m*10;
        return ans+mul;
    }
}






2)Find the Value of the Partition
You are given a positive integer array nums.

Partition nums into two arrays, nums1 and nums2, such that:

Each element of the array nums belongs to either the array nums1 or the array nums2.
Both arrays are non-empty.
The value of the partition is minimized.
The value of the partition is |max(nums1) - min(nums2)|.

Here, max(nums1) denotes the maximum element of the array nums1, and min(nums2) denotes the minimum element of the array nums2.

Return the integer denoting the value of such partition.

 

Example 1:

Input: nums = [1,3,2,4]
Output: 1
Explanation: We can partition the array nums into nums1 = [1,2] and nums2 = [3,4].
- The maximum element of the array nums1 is equal to 2.
- The minimum element of the array nums2 is equal to 3.
The value of the partition is |2 - 3| = 1. 
It can be proven that 1 is the minimum value out of all partitions.
Example 2:

Input: nums = [100,1,10]
Output: 9
Explanation: We can partition the array nums into nums1 = [10] and nums2 = [100,1].
- The maximum element of the array nums1 is equal to 10.
- The minimum element of the array nums2 is equal to 1.
The value of the partition is |10 - 1| = 9.
It can be proven that 9 is the minimum value out of all partitions.
  
  
  
  
  class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
       int min=-1;
        
        for(int i=0;i<nums.length-1;i++){
            int df=nums[i+1]-nums[i];
                if(min==-1)
                    min=df;
            else{
                if(df<min)
                    min=df;
            }
        }
        return min;
    }
}
