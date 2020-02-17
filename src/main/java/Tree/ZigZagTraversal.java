package Tree;

public class ZigZagTraversal {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.rootNode = new Node(1);
        tree.rootNode.left = new Node(2);
        tree.rootNode.right = new Node(3);
        tree.rootNode.left.left = new Node(7);
        tree.rootNode.left.right = new Node(6);
        tree.rootNode.right.left = new Node(5);
        tree.rootNode.right.right = new Node(4);

        tree.rootNode.left.left.left = new Node(10);
        tree.rootNode.left.left.right = new Node(14);
        tree.rootNode.left.right.left = new Node(11);
        tree.rootNode.left.right.right = new Node(15);
        tree.rootNode.right.left.right = new Node(12);
        tree.rootNode.right.left.left = new Node(16);
        tree.rootNode.right.right.left = new Node(13);
        tree.rootNode.right.right.right = new Node(17);

//        System.out.println("height of binary tree is : ");
//        System.out.println(tree.height(tree.rootNode));
//        System.out.println("Level Order traversal of binary tree is : ");
//        tree.levelOrderTraversal(tree.rootNode);
        System.out.println("ZigZag Order traversal of binary tree is : ");
        tree.printZigZagTraversal(tree.rootNode);
    }
}
