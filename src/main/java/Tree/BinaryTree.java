package Tree;

import java.util.Stack;

public class BinaryTree {

    public Node rootNode;

    void printZigZagTraversal(Node root) {
        int h = height(root);
        boolean leftToRight = true;
        for(int i=1; i<=h; i++) {
            printLevelElements(i, root, leftToRight);
            leftToRight = !leftToRight;
        }
    }

    int height(Node root) {
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    void levelOrderTraversal(Node root) {
        int h = height(root);
        for(int i=1; i<=h; i++) {
            printLevelElements(i, root);
        }
    }

    void printLevelElements(int level, Node node) {
        if(level == 0) return;
        if(level == 1) System.out.println(node.data);
        else {
            printLevelElements(level-1, node.left);
            printLevelElements(level-1, node.right);
        }
    }

    void printLevelElements(int level, Node node, boolean leftToRight) {
        if(level == 0) return;
        if(level == 1) System.out.println(node.data);
        else {
            if(leftToRight) {
                printLevelElements(level - 1, node.left, leftToRight);
                printLevelElements(level - 1, node.right, leftToRight);
            } else {
                printLevelElements(level - 1, node.right, leftToRight);
                printLevelElements(level - 1, node.left, leftToRight);
            }
        }
    }

    void printZigzagLevelElements(Node node) {
        Stack<Node> stack = new Stack<>();
        boolean leftToRight = true;
        stack.push(node);
        int h = height(node);
        for(int i=0; i<h; i++) {
            while (!stack.contains(node)) {
                Node n = stack.pop();
                System.out.println(n.data);
            }

            if(leftToRight) {
                if(node.left != null) stack.push(node.left);
                if(node.right != null) stack.push(node.right);
            } else {
                if(node.right != null) stack.push(node.right);
                if(node.left != null) stack.push(node.left);
            }
            leftToRight = !leftToRight;
        }

    }
}
