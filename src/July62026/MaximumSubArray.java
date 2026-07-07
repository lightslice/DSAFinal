package July62026;

import java.util.*;

public class MaximumSubArray {
    //Brute Force Method
//    public static int maxSubArray(int[] nums){
//        int maxSum = nums[0];
//        for(int i=0;i<nums.length;i++){
//            int currSum = 0;
//            for(int j=i;j<nums.length;j++){
//                currSum += nums[j];
//                if(currSum > maxSum){
//                    maxSum = currSum;
//                }
//            }
//        }
//        return maxSum;
//    }

    //Optimized method : Kadane's Algorithm
    public static int maxSubArray(int[] nums){
        int maxSum = nums[0];
        int currSum = nums[0];
        for(int i=1;i<nums.length;i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(nums);
        System.out.println(result);
    }
}
