

 //�ж����Ƿ�ΪΪƽ���������������߶Ȳ�ľ���ֵС�ڵ���1��
class BalancedTree{

    public int height(Node root) {
        if(root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        int height = Math.max(left,right);
        return height + 1;
    }

    public boolean isBalanced(Node root) {
//���һ��������ƽ����
        if(root == null){
            return true;
        }
        //��������Ҳ��������ƽ����
        boolean leftBalanced = isBalanced(root.left);
        if(!leftBalanced){
            return false;
        }
        boolean rightBalanced = isBalanced(root.right);
        if(!rightBalanced){
            return false;
        }
        //�ж���������������ֵ���С�ڵ���1
        int leftHeight = calcHeight(root.left);
        int rightHeight = calcHeight(root.right);
        int diff = leftHeight - rightHeight;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return true;
    }
}