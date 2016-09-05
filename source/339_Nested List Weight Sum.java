/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    private final static int EMPTY_LIST_WEIGHT = 0;
    private final static int INITIAL_LEVEL = 1;

    /**
     * A method to calculate nested weight sum.
     * @param nestedList the input nestedList
     * @return the integer value of sum weight
     */
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null)  return EMPTY_LIST_WEIGHT;
        return getCurrentDepthSum(nestedList, INITIAL_LEVEL);
    }
    
    /**
     * A helper for method depthSum to calculate current level weight sum.
     * @param nestedList the input nestedList
     * @param currentLevel currentLevel in the nestedList
     * @return the integer value of current sum weight
     */
    private int getCurrentDepthSum(List<NestedInteger> nestedList, int currentLevel) {
        if(nestedList == null)  return EMPTY_LIST_WEIGHT;
        int weightSum = 0;
        for(NestedInteger nestedElement : nestedList) {
            if(nestedElement.isInteger()) {
                weightSum += currentLevel * nestedElement.getInteger();
            } else {
                weightSum += getCurrentDepthSum(nestedElement.getList(), currentLevel + 1);
            }
        }
        return weightSum;
    }
}
