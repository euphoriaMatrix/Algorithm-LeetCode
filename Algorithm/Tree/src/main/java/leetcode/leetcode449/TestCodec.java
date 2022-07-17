package leetcode.leetcode449;

/**
 * @author xwfstart
 * @create 2022-05-11 23:45
 */
public class TestCodec {
    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String tree = ser.serialize(root);
        System.out.println(tree);
 TreeNode ans = deser.deserialize(tree);
    }
}
