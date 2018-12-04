//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @ClassName: BinTree
// * @Description: TODO
// * @Author: Mr.Ye
// * @Data: 2018-11-22 18:25
// * @Version: 1.0
// **/
//
//class BinTree {
//    private BinTree lChild;//左孩子
//    private BinTree rChild;//右孩子
//    private BinTree root;//根节点
//    private Object data; //数据域
//    private List<BinTree> datas;//存储所有的节点
//
//    public BinTree(BinTree lChild, BinTree rChild, Object data) {
//        super();
//        this.lChild = lChild;
//        this.rChild = rChild;
//        this.data = data;
//    }
//
//    public BinTree(Object data) {
//        this(null, null, data);
//    }
//
//    public BinTree() {
//        super();
//    }
//
//    public void createTree(Object[] objs) {
//        datas = new ArrayList<BinTree>();
//        for (Object object : objs) {
//            datas.add(new BinTree(object));
//        }
//        root = datas.get(0);//将第一个作为根节点
//        for (int i = 0; i < objs.length / 2; i++) {
//            datas.get(i).lChild = datas.get(i * 2 + 1);
//            if (i * 2 + 2 < datas.size()) {//避免偶数的时候 下标越界
//                datas.get(i).rChild = datas.get(i * 2 + 2);
//            }
//        }
//    }
//
//    //先序遍历
//    public void preorder(BinTree root) {
//        if (root != null) {
//            visit(root.getData());
//            preorder(root.lChild);
//            preorder(root.rChild);
//        }
//
//    }
//
//    //中序遍历
//    public void inorder(BinTree root) {
//        if (root != null) {
//            inorder(root.lChild);
//            visit(root.getData());
//            inorder(root.rChild);
//        }
//
//    }
//
//    //后序遍历
//    public void afterorder(BinTree root) {
//        if (root != null) {
//            afterorder(root.lChild);
//            afterorder(root.rChild);
//            visit(root.getData());
//        }
//
//    }
//
//    private void visit(Object obj) {
//        System.out.print(obj + " ");
//    }
//
//    public Object getData() {
//        return data;
//    }
//
//    public BinTree getRoot() {
//        return root;
//    }
//
//}
//
//class BinTreeTest {
//    public static void main(String[] args) {
//        BinTree binTree = new BinTree();
//        Object[] objs = {0, 1, 2, 3, 4, 5, 6, 7};
//        binTree.createTree(objs);
////		binTree.preorder(binTree.getRoot()); //先序遍历
////      binTree.inorder(binTree.getRoot()); //中序遍历
//        binTree.afterorder(binTree.getRoot()); //后序遍历
//    }
//}

//---------------------------------------------------------


import java.util.ArrayList;
import java.util.List;

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
//    public void createTree(Object[] objs) {
//        datas = new ArrayList<BinTree>();
//        for (Object object : objs) {
//            datas.add(new BinTree(object));
//        }
//        root = datas.get(0);//将第一个作为根节点
//        for (int i = 0; i < objs.length / 2; i++) {
//            datas.get(i).lChild = datas.get(i * 2 + 1);
//            if (i * 2 + 2 < datas.size()) {//避免偶数的时候 下标越界
//                datas.get(i).rChild = datas.get(i * 2 + 2);
//            }
//        }
//    }

    public void insert(int[] obj) { // 插入
        Node[] nodes = new Node[obj.length];
        for (int i = 0; i < obj.length; i++){
            nodes[i] = new Node(obj[i]);
        }
        root = nodes[0];
        for (int i = 0; i < obj.length / 2; i++) {
            nodes[i].left = nodes[i * 2 + 1];
            if (i * 2 + 2 < nodes.length) {
                nodes[i].right = nodes[i * 2 + 2];
            }
        }
    }
    public void insert_1(int[] obj, int size){
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new Node(obj[i]));
        }
        root = list.get(0);
        for (int i = 0; i < size/2; i++) {
            list.get(i).left = list.get(i * 2 + 1);
            if (i * 2 + 2 < size) {
                list.get(i).right = list.get(i*2+2);
            }
        }
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
        int[] result = new int[]{0,1,2,3,4,5,6};
//        int[] result = new int[]{};

//        for (int i = 0; i < result.length; i++) {
//            bt.insert(result[i]);
//        }

        bt.insert(result);
        bt.printTree(); // 先序遍历


        for (int i = 0; i < result.length; i++) {
            bt.insert_1(result, result.length);
        }

        bt.printTree(); // 先序遍历
//        bt.printTree1(); // 中序遍历
//        bt.printTree2(); // 后序遍历
//
//        System.out.println("7是否存在树中： " + bt.contains(7)); // 判断 一个值 是否存在树中
//        System.out.println("10是否存在树中： " + bt.contains(10));
//
//        System.out.println("该树的最大值是： " + bt.getMin()); // 查找最小值并输出
//        System.out.println("该树的最小值是： " + bt.getMax()); // 查找最大值并输出
    }
}
