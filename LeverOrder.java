class LeverOrder{

//��װһ�������ڱ�����������
 private static class Element{
        Node node;
        int level;
        Element(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static List<List<Character>> levelOrder(Node root) {
        List<List<Character>> retList = new ArrayList<>();

        if(root == null) {
            return retList;
        }
        //�����д�ŵ��ǽ���������
        Queue<Element> queue = new LinkedList<>();
        Element e = new Element(root, 0);
        queue.add(e);
        while(!queue.isEmpty()) {
            Element front = queue.poll();
           //���ݲ��������еĽ����벻ͬ�����Ա���
            if (front.level == retList.size()) {
                retList.add(new ArrayList<>());
            }
            retList.get(front.level).add(front.node.val);
            if (front.node.left != null) {
                Element l = new Element(front.node.left,front.level + 1);
                queue.add(l);
            }
            if (front.node.right != null) {
                Element r = new Element(front.node.right,front.level + 1);
                queue.add(r);
            }
        }
        return retList;
    }
}