/**
 * @ClassName: BinTree
 * @Description: TODO
 * @Author: Mr.Ye
 * @Data: 2018-11-21 15:23
 * @Version: 1.0
 **/

class BinTreeNode {
    private Node root; // 根节点

    private class Node {
        private Node left; // 左孩子
        private Node right; // 右孩子
        private Integer data; // 值

        public Node(Integer data) {
            this(null, null, data);
        }

        public Node(Node left, Node right, Integer data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    public Node getRoot() {
        return root;
    }

    //-----------------------------------------------------------


    // 插入
    public void insert(Integer obj) {
        root = insert(root, obj);
    }

    // 判空
    public boolean isEmpty() {
        return root == null;
    }

    // 置空
    public void makeEmpty() {
        root = null;
    }

    // 判断一个值在树种是否存在
    public boolean contains(Integer n) {
        return _contains(root, n);
    }

    // 查找最小值
    public Integer getMin() {
        if (isEmpty()) { // 空树 返回
            return null;
        } else
            return _getMin(root).data;
    }

    // 查找最大值
    public Integer getMax() {
        if (isEmpty()) {
            return null;
        } else
            return _getMax(root).data;
    }

    // 树的遍历

    public void printTree() {
        System.out.println("先序遍历：");
        printTree(root);
        System.out.println();
    }

    public void printTree1() {
        System.out.println("中序遍历：");
        printTree1(root);
        System.out.println();
    }

    public void printTree2() {
        System.out.println("后序遍历：");
        printTree2(root);
        System.out.println();
    }


    //-----------------------------------------------------------

    private Node insert(Node root, Integer obj) { // 插入
        if (root == null) {
            return new Node(obj);
        }
        int num = obj.compareTo(root.data);
        if (num < 0) {
            root.left = insert(root.left, obj);
        } else if (num > 0) {
            root.right = insert(root.right, obj);
        }
        return root;
    }

    private boolean _contains(Node root, Integer obj) { // 判断obj是否存在树中
        if (root == null) { // 树为空
            return false;
        }
        if (obj < root.data) { // obj比根节点大，到左子树查找
            return _contains(root.left, obj);
        } else if (obj > root.data) { // obj比根节点小，到右子树查找
            return _contains(root.right, obj);
        } else
            return true; // obj等于根节点直接返回true
    }

    private Node _getMin(Node root) { // 查找最小值
        if (root.left == null) { // 根节点左子树为空，最小值为根节点
            return root;
        }
        return _getMin(root.left); // 根节点左子树不为空，最小值是左子树最左边的
    }

    private Node _getMax(Node root) { // 查找最大值
        if (root.right == null) {
            return root;
        }
        return _getMax(root.right);
    }

    private void printTree(Node root) { // 先序遍历
        if (root != null) {
            System.out.print(root.data + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }

    private void printTree1(Node root) { // 中序遍历
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data + " ");
            printTree(root.right);
        }
    }

    private void printTree2(Node root) { // 后序遍历
        if (root != null) {
            printTree(root.left);
            printTree(root.right);
            System.out.print(root.data + " ");
        }
    }

}

public class BinTree {
    public static void main(String[] args) {
        BinTreeNode bt = new BinTreeNode();
        int[] result = new int[]{6, 4, 5, 2, 8, 9, 7};
//        int[] result = new int[]{};

        for (int i = 0; i < result.length; i++) {
            bt.insert(result[i]);
        }

        bt.printTree(); // 先序遍历
        bt.printTree1(); // 中序遍历
        bt.printTree2(); // 后序遍历

        System.out.println("7是否存在树中： " + bt.contains(7)); // 判断 一个值 是否存在树中
        System.out.println("10是否存在树中： " + bt.contains(10));

        System.out.println("该树的最大值是： " + bt.getMin()); // 查找最小值并输出
        System.out.println("该树的最小值是： " + bt.getMax()); // 查找最大值并输出
    }
}
