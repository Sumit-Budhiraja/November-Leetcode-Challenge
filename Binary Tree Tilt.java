class Solution {
  public int findTilt(TreeNode root) {
    int[] total = {0};
    helper(root, total);
    return total[0];
  }
  
  private int helper(TreeNode root, int[] total) {
    if (root == null) {
      return 0;
    }
    int left = helper(root.left, total);
    int right = helper(root.right, total);
    total[0] += Math.abs(left - right);
    return left + right + root.val;
  }
}