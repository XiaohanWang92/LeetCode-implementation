public class Solution {

    class Node {
        Node left;
        Node right;
        int value;
        int leftSubTreeTotalNum;
        int occurrNum = 1;
        public Node(int v, int lsttn) {
            value = v;
            leftSubTreeTotalNum = lsttn;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] results = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, results, i, 0);
        }
        return Arrays.asList(results);
    }

    private Node insert(int num, Node node, Integer[] results, int i, int prevTotalNum) {
        if (node == null) {
            node = new Node(num, 0);
            results[i] = prevTotalNum;
        } else if (node.value == num) {
            node.occurrNum++;
            results[i] = prevTotalNum + node.leftSubTreeTotalNum;

        // go left
        } else if (node.value > num) {
            node.leftSubTreeTotalNum++;
            node.left = insert(num, node.left, results, i, prevTotalNum);

        // go right
        } else {
            node.right = insert(num, node.right, results, i, prevTotalNum + node.occurrNum + node.leftSubTreeTotalNum);
        }
        return node;
    }
}
