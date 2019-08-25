class LevelOrderTraversal{
    //�������
    public static void levelOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        //��ÿ����㰴��һ��һ���˳��ѹ�����
        //���γ��Ӿ͵õ��������Ĳ���������
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            Node front = queue.poll();
            if(front.left != null){
                queue.add(front.left);
            }
            if(front.right != null){
                queue.add(front.right);
            }
        }
    }
}