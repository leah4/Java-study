class LowestCommonAncestor{
  
  //����һ������Ƿ������һ������
    public boolean search(Node root,Node n){
        if(root == null) {
            return false;
        }
        if (root == n){
            return true;
        }
        if (search(root.left,n)) {
            return true;
        }
        return search(root.right,n);
    }
    //�����������Ĺ�������
    public Node lowestCommonAncestor(Node root, Node p, Node q){
        if(root == p || root == q) {
            return root;
        }

        boolean pInLeft = search(root.left,p);
        boolean qInLeft = search(root.left,q);
        //�����������㶼���������У�ȥ���������ҹ�������
        if(pInLeft && qInLeft) {
            return lowestCommonAncestor(root.left,p,q);
        }
        //�����������㶼���������У�ȥ���������ҹ�������
        if(!pInLeft && !qInLeft) {
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}