package com.javawiz.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class Problem1 {
    public static void main(String[] args) {
        Problem1 p1 = new Problem1();
        System.out.print("Input: nums = [2,7,11,15, target = 9, "
                + "Output Index = ["+ Arrays.stream(p1.twoSum(new int[]{2,7,11,15}, 9))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "))+"]");

        System.out.println();
        System.out.print("Input: nums = [3,2,4], target = 6, "
                + "Output Index = ["+ Arrays.stream(p1.twoSum(new int[]{3,2,4}, 6))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "))+"]");
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers =  new HashMap<>();
        for(int i= 0; i< nums.length; i++){
            numbers.put(nums[i], i);
        }

        for (int i = 0, place=i; i < nums.length; i++) {
            int diff = target - nums[i];
            if(numbers.containsKey(diff)){
                place = numbers.get(diff);
                if(i != place){
                    return new int[]{i, place};
                }
            }
        }
        return new int[]{0,0};
    }
}
