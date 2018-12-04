package BT;

import java.util.Stack;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: Mr.Ye
 * @Data: 2018-12-04 13:47
 * @Version: 1.0
 **/

// 定义一个节点类，使节点与二叉树操作分离
class Node {
    int value;
    Node leftChild;
    Node rightChild;

    Node(int value) {
        this.value = value;
    }

    public void display() {
        System.out.print(this.value + "\t");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.valueOf(value);
    }
}

//---------------------------------------
//需要实现的二叉树操作
class BinaryTree {
    private Node root = null;

    BinaryTree(int value) {
        root = new Node(value);
        root.leftChild = null;
        root.rightChild = null;
    }
//    public Node findKey(int value) {}   //查找
//    public String insert(int value) {}  //插入
//    public void inOrderTraverse() {}    //中序遍历递归操作
//    public void inOrderByStack() {}     //中序遍历非递归操作
//    public void preOrderTraverse() {}  //前序遍历
//    public void preOrderByStack() {}   //前序遍历非递归操作
//    public void postOrderTraverse() {} //后序遍历
//    public void postOrderByStack() {}  //后序遍历非递归操作
//    public int getMinValue() {} //得到最小(大)值
//    public boolean delete(int value) {} //删除

    //  查找
    public Node findKey(int value) {
        Node current = root;
        while (true) {
            if (value == current.value) {
                return current;
            } else if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }
    }

    // 插入
    public String insert(int value) {
        String error = null;

        Node node = new Node(value);
        if (root == null) {
            root = node;
            root.leftChild = null;
            root.rightChild = null;
        } else {
            Node current = root;
            Node parent = null;
            while (true) {
                if (value < current.value) {
                    parent = current;
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        break;
                    }
                } else if (value > current.value) {
                    parent = current;
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        break;
                    }
                } else {
                    error = "having same value in binary tree";
                }
            } // end of while
        }
        return error;
    }

    /**
     * //中序遍历(递归)：
     * 1、调用自身来遍历节点的左子树
     * 2、访问这个节点
     * 3、调用自身来遍历节点的右子树
     */
    public void inOrderTraverse() {
        System.out.print("中序遍历:");
        inOrderTraverse(root);
        System.out.println();
    }

    private void inOrderTraverse(Node node) {
        if (node == null)
            return;

        inOrderTraverse(node.leftChild);
        node.display();
        inOrderTraverse(node.rightChild);
    }

    /**
     * 中序非递归遍历：
     * 1）对于任意节点current，若该节点不为空则将该节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     * 2）若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current
     * 3) 重复1、2步操作，直到current为空且栈内节点为空。
     */
    public void inOrderByStack() {
        System.out.print("中序非递归遍历:");
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                current.display();
                current = current.rightChild;
            }
        }
        System.out.println();
    }

    //---------------

    /**
     * //前序遍历(递归)：
     * 1、访问这个节点
     * 2、调用自身来遍历节点的左子树
     * 3、调用自身来遍历节点的右子树
     */
    public void preOrderTraverse() {
        System.out.print("前序遍历:");
        preOrderTraverse(root);
        System.out.println();
    }

    private void preOrderTraverse(Node node) {
        if (node == null)
            return;

        node.display();
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 前序非递归遍历：
     * 1）对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     * 2）若左子树为空，栈顶节点出栈，将该节点的右子树置为current
     * 3) 重复1、2步操作，直到current为空且栈内节点为空。
     */
    public void preOrderByStack() {
        System.out.print("前序非递归遍历:");
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current.display();
                current = current.leftChild;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.rightChild;
            }
        }
        System.out.println();
    }

    //----------------------

    /**
     * //后序遍历(递归)：
     * 1、调用自身来遍历节点的左子树
     * 2、调用自身来遍历节点的右子树
     * 3、访问这个节点
     */
    public void postOrderTraverse() {
        System.out.print("后序遍历:");
        postOrderTraverse(root);
        System.out.println();
    }

    private void postOrderTraverse(Node node) {
        if (node == null)
            return;

        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        node.display();
    }

    /**
     * 后序非递归遍历：
     * 1）对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     * 2）若左子树为空，取栈顶节点的右子树，如果右子树为空或右子树刚访问过，则访问该节点，并将preNode置为该节点
     * 3) 重复1、2步操作，直到current为空且栈内节点为空。
     */
    public void postOrderByStack() {
        System.out.print("后序非递归遍历:");
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        Node preNode = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }

            if (!stack.isEmpty()) {
                current = stack.peek().rightChild;
                if (current == null || current == preNode) {
                    current = stack.pop();
                    current.display();
                    preNode = current;
                    current = null;
                }
            }
        }
        System.out.println();
    }

    //------------------------------------
    //得到最小(大)值：依次向左(右)直到空为之
    public int getMinValue() {
        Node current = root;
        while (true) {
            if (current.leftChild == null)
                return current.value;

            current = current.leftChild;
        }
    }

    //------------------------------------
    //删除：删除操作很复杂，删除节点大致分为三种情况：
    public boolean delete(int value) {
        Node current = root;    //需要删除的节点
        Node parent = null;     //需要删除的节点的父节点
        boolean isLeftChild = true;   //需要删除的节点是否父节点的左子树

        while (true) {
            if (value == current.value) {
                break;
            } else if (value < current.value) {
                isLeftChild = true;
                parent = current;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                parent = current;
                current = current.rightChild;
            }

            //找不到需要删除的节点，直接返回
            if (current == null)
                return false;
        }

        //分情况考虑
        //1、需要删除的节点为叶子节点
        if (current.leftChild == null && current.rightChild == null) {
            //如果该叶节点为根节点，将根节点置为null
            if (current == root) {
                root = null;
            } else {
                //如果该叶节点是父节点的左子节点，将父节点的左子节点置为null
                if (isLeftChild) {
                    parent.leftChild = null;
                } else { //如果该叶节点是父节点的右子节点，将父节点的右子节点置为null
                    parent.rightChild = null;
                }
            }
        }
        //2、需要删除的节点有一个子节点，且该子节点为左子节点
        else if (current.rightChild == null) {
            //如果该节点为根节点，将根节点的左子节点变为根节点
            if (current == root) {
                root = current.leftChild;
            } else {
                //如果该节点是父节点的左子节点，将该节点的左子节点变为父节点的左子节点
                if (isLeftChild) {
                    parent.leftChild = current.leftChild;
                } else {  //如果该节点是父节点的右子节点，将该节点的左子节点变为父节点的右子节点
                    parent.rightChild = current.leftChild;
                }
            }
        }
        //2、需要删除的节点有一个子节点，且该子节点为右子节点
        else if (current.leftChild == null) {
            //如果该节点为根节点，将根节点的右子节点变为根节点
            if (current == root) {
                root = current.rightChild;
            } else {
                //如果该节点是父节点的左子节点，将该节点的右子节点变为父节点的左子节点
                if (isLeftChild) {
                    parent.leftChild = current.rightChild;
                } else {  //如果该节点是父节点的右子节点，将该节点的右子节点变为父节点的右子节点
                    parent.rightChild = current.rightChild;
                }
            }
        }
        //3、需要删除的节点有两个子节点，需要寻找该节点的后续节点替代删除节点
        else {
            Node successor = getSuccessor(current);
            //如果该节点为根节点，将后继节点变为根节点，并将根节点的左子节点变为后继节点的左子节点
            if (current == root) {
                root = successor;
            } else {
                //如果该节点是父节点的左子节点，将该节点的后继节点变为父节点的左子节点
                if (isLeftChild) {
                    parent.leftChild = successor;
                } else {  //如果该节点是父节点的右子节点，将该节点的后继节点变为父节点的右子节点
                    parent.rightChild = successor;
                }
            }
        }
        current = null;
        return true;
    }

    /**
     *
     * 得到后继节点，即删除节点的左后代
     */
    private Node getSuccessor(Node delNode) {
        Node successor = delNode;
        Node successorParent = null;
        Node current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        //如果后继节点不是删除节点的右子节点时，
        if (successor != delNode.rightChild) {
            //要将后继节点的右子节点指向后继结点父节点的左子节点，
            successorParent.leftChild = successor.rightChild;
            //并将删除节点的右子节点指向后继结点的右子节点
            successor.rightChild = delNode.rightChild;
        }
        //任何情况下，都需要将删除节点的左子节点指向后继节点的左子节点
        successor.leftChild = delNode.leftChild;

        return successor;
    }



}

public class Test {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(52);
        bt.insert(580);
        bt.insert(12);
        bt.insert(50);
        bt.insert(58);
        bt.insert(9);
        bt.insert(888);
        bt.insert(248);
        bt.insert(32);
        bt.insert(666);
        bt.insert(455);
        bt.insert(777);
        bt.insert(999);
        bt.inOrderTraverse();
        bt.preOrderTraverse();
        bt.postOrderTraverse();
        System.out.println(bt.findKey(32));
        System.out.println(bt.findKey(81));
        System.out.println("最小值:" + bt.getMinValue());
//		bt.delete(32);      //删除叶子节点
//		bt.delete(50);      //删除只有一个左子节点的节点
//		bt.delete(248);      //删除只有一个右子节点的节点
//		bt.delete(248);      //删除只有一个右子节点的节点
//		bt.delete(580);      //删除有两个子节点的节点，且后继节点为删除节点的右子节点的左后代
//		bt.delete(888);      //删除有两个子节点的节点，且后继节点为删除节点的右子节点
        bt.delete(52);       //删除有两个子节点的节点，且删除节点为根节点

        bt.inOrderTraverse();
    }
}

