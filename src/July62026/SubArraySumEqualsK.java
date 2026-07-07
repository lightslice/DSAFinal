package July62026;

import java.util.HashMap;

public class SubArraySumEqualsK {
    //Brute Force method
//    public static int subArraySum(int[] nums, int k){
//        int count = 0;
//        for(int i=0;i<nums.length;i++){
//            int sum = 0;
//            for(int j=i;j<nums.length;j++){
//                sum += nums[j];
//                if(sum == k){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    //Optimized method : HashMap + PresfixSum
    public static int subArraySum(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum =0;
        int count = 0;
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum , 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        int result = subArraySum(nums, k);

        System.out.println(result);
    }
}
