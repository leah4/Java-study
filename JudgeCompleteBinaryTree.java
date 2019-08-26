class  JudgeCompleteBinaryTree{ 
//�ж��Ƿ�Ϊ��ȫ������
   public static boolean isComplete(Node root) {
        if(root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        //��ÿ����㰴�ղ������ѹ�����
        //���δӶ����н���㵯��  ֱ�������ս��
        while(true) {
            Node front = queue.poll();
            if(front == null) {
                break;
            }
            queue.add(front.left);
            queue.add(front.right);
        }
        //�ж�ʣ�¶������Ƿ���ڲ��ǿյĽ��
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node != null) {
                return false;
            }
        }
        return true;
    }
}