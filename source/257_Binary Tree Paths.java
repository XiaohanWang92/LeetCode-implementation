/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<>();
        if(root != null) {
            DFS(root, "", pathList);
        }
        return pathList;
    }
    private void DFS(TreeNode subRoot,String path, List<String> pathList) {
        if(subRoot.left == null && subRoot.right == null) {
            pathList.add(path + subRoot.val);
        }
        if(subRoot.left != null) {
            DFS(subRoot.left, path + subRoot.val + "->", pathList);
        }
        if(subRoot.right != null) {
            DFS(subRoot.right, path + subRoot.val + "->", pathList);
        }
    }
}
/**below is my NAC wrong solution using StringBuffer:
******************************************************
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<>();
        ArrayList<StringBuffer> build = new ArrayList<>();
        if(root!=null){
            StringBuffer stb = new StringBuffer();
            DFS(root,stb,build);
        //foreach
            for(StringBuffer s:build){
                pathList.add(s.toString());
            }
        }
        return pathList;
    }
    private void DFS(TreeNode subRoot,StringBuffer path, List<StringBuffer> build){
        if(subRoot.left==null&&subRoot.right==null){
            path.append(subRoot.val);
            build.add(path);
        }
        if(subRoot.left!=null){
            path.append(subRoot.val+"->");
            DFS(subRoot.left,path,build);
        }
        if(subRoot.right!=null){
            path.append(subRoot.val+"->");
            DFS(subRoot.right,path,build);
        }
    }
}
******************************************************
for a tree [1,2,3]
output will be ["1->21->3","1->21->3"] instead of ["1->2","1->3"]//?
//why not 1->2, 1->21->3??
**/
