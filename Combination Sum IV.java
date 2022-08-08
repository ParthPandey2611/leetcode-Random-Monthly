// Question -> https://leetcode.com/problems/combination-sum-iv/
// Approach -> https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation
//             https://www.youtube.com/watch?v=Wct0mN2SCRQ&t=628s

// recursive solution
class Solution {
public int combinationSum4(int[] nums, int target) {
    if (target == 0) {
        return 1;
    }
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
        if (target >= nums[i]) {
            res += combinationSum4(nums, target - nums[i]);
        }
    }
    return res;
  }
}
// Time Limit Exceeded will occur because overlapping swap problem ho rahi hai or usmae time constraint satisfy nhi karega , toh DP ka scope hai


// Top-Down approach or Memoization approach 
class Solution {
    private int[] dp ;
    public int combinationSum4(int[] nums, int target) {
        dp= new int[target+1]; // if you have to convert Recursion into memoization then create an DP array
        Arrays.fill(dp,-1);    // intialize dp with -1 in starting
        dp[0]=1; // matlab base case ko intialize karaengae ,agar target 0 tha toh 1 intialize kardiyae
        return findWays(nums , target);
    }
        private int findWays(int[] nums , int target){
          if(dp[target]!=-1){  // matlab intial mae hum nae -1 declare kiya tha or agar -1 nhi hai toh matlab koi result store hua rakha hai
              return dp[target];
          }
            int result = 0 ;
            for(int i =0 ; i<nums.length ; i++){
                if(target>=nums[i]){
               result += findWays(nums,target-nums[i]);  // here we use 1D dp because only one parameter is changing which is target-nums[i]
                                                         // here Recursive calling is being done , which is findways
                }
               }
             dp[target] = result;   // store result in dp[target] and then return dp[target]
                return dp[target] ;
       }
}