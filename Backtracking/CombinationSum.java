package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        findCombinations(0, candidates, target, result, currentCombination);
        return result;
    }
    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds)); 
            return;
        }
        if (ind == arr.length) {
            return;
        }
        if (arr[ind] <= target) { 
            ds.add(arr[ind]); 
            findCombinations(ind, arr, target - arr[ind], ans, ds); 
            ds.remove(ds.size() - 1); 
        }
        findCombinations(ind + 1, arr, target, ans, ds); 
    }
    public static void main(String[] args) {
        
    }
}
