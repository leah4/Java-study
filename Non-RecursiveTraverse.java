import java.util.*;

class Node{
    char val;  //���ֵ
    Node left = null;  //ָ������   ���������Ϊ��������������
    Node right = null; //ָ���Һ���   ������Һ���Ϊ��������������
    Node (char val) {
        this.val = val;
    }
}

public class Non-RecursiveTraverse{
 //ǰ�к���ǵݹ�д��
    /*�ǵݹ�  vs   �ݹ�
     ջ�ռ�����׿���
     �ݹ�ʹ�õ�ջ��ϵͳ����ջ,�ռ��С��һ���С�ȽϹ̶�
     �ǵݹ�ʵ��ջ��ջ�Ŀռ��ڶ��ϣ�һ��Ƚϴ�
     */

//ǰ��
    public static void preorderNoR(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while (!stack.empty() || cur != null) {
            while (cur != null) {
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            Node top = stack.pop();
            cur = top.right;
        }
    }

//����
    public static void inorderNoR(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.println(top.val);
            cur = top.right;
        }
    }

//����
    public static void postorderNoR(Node root) {
        //�������  ������㱻�����ξ������Ⱥ�˳��������
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        //��ʾ��һ�������ξ����Ľ��
        Node last = null;
        while(!stack.empty() || cur != null) {
            //���Ȳ���ѹ������
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //���������Ϊ��  �ж����Ƿ�Ϊ�����������
            Node top = stack.peek();
            if (top.right == null || top.right == last) {
                stack.pop();
                System.out.println(top.val);
                last = top;
            } else {
                cur = top.right;
            }
        }
    }

    public static void main(String[] args) {
        Node root = buildTree();
        preorderNoR(root);
        System.out.println(   );
        inorderNoR(root);
        System.out.println(   );
        postorderNoR(root);
    }

    public static Node buildTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        e.right = h;

        return a;
    }
}
