package leetcode449;

/**
 * @author xwfstart
 * @create 2022-05-11 23:44
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString().substring(0, sb.length() - 1);
    }

    // 前序遍历
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val + " ");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] list = data.split(" ");
        int n = list.length;
        return getRoot(list, 0, n - 1);
    }

    private TreeNode getRoot(String[] list, int start, int end) {
        if (start == end) return new TreeNode(Integer.parseInt(list[start]));
        if (start < end) return null;
        TreeNode node = new TreeNode(Integer.parseInt(list[start]));
        int mid = start + 1;
        while (mid <= end) {
            int num = Integer.parseInt(list[mid]);
            if (node.val < num) break;
            mid++;
        }
        node.left = getRoot(list, start + 1, mid - 1);
        node.right = getRoot(list, mid, end);
        return node;
    }
}
