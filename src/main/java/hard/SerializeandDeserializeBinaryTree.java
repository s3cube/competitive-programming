package hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {


    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        one.left = new TreeNode(2);
        one.right = new TreeNode(3);
        one.right.left = new TreeNode(4);
        one.right.right = new TreeNode(5);


        String serialized = new SerializeandDeserializeBinaryTree().serialize(one);


        TreeNode tree = new SerializeandDeserializeBinaryTree().deserialize(serialized);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();


        serializeHelper(root, sb);

        return sb.toString();

    }

    private void serializeHelper(TreeNode root, StringBuilder sb){

        if(root == null){
            sb.append("NULL").append(',');
            return;
        }

        sb.append(root.val).append(',');

        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);




    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String arr[] = data.split(",");
        Queue<String> queue = new ArrayDeque<>();

        queue.addAll(Arrays.asList(arr));

        TreeNode begin = new TreeNode(-1);
        TreeNode root = deserializeHelper(begin, queue);

        return root;
    }

    private TreeNode deserializeHelper(TreeNode root, Queue queue){

        if (!queue.isEmpty()){
            String frontOfQueue = (String) queue.poll();
            if(!frontOfQueue.equals("NULL"))
                root = new TreeNode(Integer.parseInt(frontOfQueue));
            else{
                return null;
            }

            root.left = deserializeHelper(root, queue);
            root.right = deserializeHelper(root, queue);
        }

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
