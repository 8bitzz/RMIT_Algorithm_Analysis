import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**                                                                                 
  ,dW"Yvd `7MMpMMMb.pMMMb.  M"""MMV     ,p6"bo   ,pW"Wq.`7MMpMMMb.pMMMb.      ,6"Yb.`7MM  `7MM  
 ,W'   MM   MM    MM    MM  '  AMV     6M'  OO  6W'   `Wb MM    MM    MM     8)   MM  MM    MM  
 8M    MM   MM    MM    MM    AMV      8M       8M     M8 MM    MM    MM      ,pm9MM  MM    MM  
 YA.   MM   MM    MM    MM   AMV  , ,, YM.    , YA.   ,A9 MM    MM    MM  ,, 8M   MM  MM    MM  
  `MbmdMM .JMML  JMML  JMML.AMMmmmM db  YMbmd'   `Ybmd9'.JMML  JMML  JMML.db `Moo9^Yo.`Mbod"YML.
       MM                                                                                       
     .JMML.                                                                                     
       
 * This code snippet is copyright at qmz.com.au
 * - qmz.com.au is a top-ranking IT consulting firm that specialised in
 * - Mobile Development, Web Development, Machine Learning, and Cloud Computing.
 * - We provide individual and company training for professional development.
 * - Find out more information in our official site：
 * - https://qmz.com.au                                                                   
 */

// Given a set of distinct integers, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// Example:

// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]


class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    ArrayList<List<Integer>> result = new ArrayList();
    if (nums == null ) { return result; }
    if (nums.length == 0) {
      result.add(new ArrayList<Integer>());
      return result;
    }

    Arrays.sort(nums);
    ArrayList<Integer> subset = new ArrayList<Integer>();
    recursion(subset, nums, 0, result);
    
    return result;
  }

  private void recursion(List<Integer> subset,
                         int[] nums,
                         int startIndex,
                         List<List<Integer>> result) {
    // deep copy
    result.add(new ArrayList<Integer>(subset));

    for (int i = startIndex; i < nums.length; i++) {
      subset.add(nums[i]);
      recursion(subset, nums, i + 1, result);
      subset.remove(subset.size() - 1);
    }
  }

}