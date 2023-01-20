//https://leetcode.com/problems/combination-sum



//for loop based recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null) return result;
        helper(candidates,0,target,new ArrayList<>());
        return result;
    }
    
    private void helper(int [] candidates, int index, int target, List<Integer> list){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(target<0) return;
        for(int i=index;i<candidates.length;i++){
            list.add(candidates[i]);
            helper(candidates, i, target-candidates[i], list);
            list.remove(list.size()-1);
        }
    }
}

//choose not choose recursion

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null) return result;
        helper(candidates,0,target,new ArrayList<>());
        return result;
    }
    
    private void helper(int [] candidates, int index, int target, List<Integer> list){
        if(target == 0){
            result.add(list);
            return;
        }
        if(target<0 || index == candidates.length) return;
        //choose
        List<Integer> temp = new ArrayList<>(list);
        temp.add(candidates[index]);
        helper(candidates, index, target-candidates[index], temp);
        //dont choose
        helper(candidates, index+1, target, new ArrayList<>(list));
    }
}
