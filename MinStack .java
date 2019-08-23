import java.util.Stack;

public class MinStack {
    //��������ջ�ֱ����ڴ�ÿ��Ԫ��  ����СԪ��
    Stack<Integer> normal = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack(){
    }

    public void push(int x){
        normal.push(x);
        //�ж������СջΪ���򽫵�ǰԪ��ѹ����Сջ
        if (min.empty()) {
            min.push(x);
        } else {   //����Сջ��Ϊ�� ���ж���Сջ�е�ǰԪ�� ��Ҫѹ���Ԫ�صĴ�С  ��С��һ��ѹ����Сջ
            int m = min.peek();
            if (x <= m){
                min.push(x);
            } else {
                min.push(m);
            }
        }
    }

    public void pop(){
        normal.pop();
        min.pop();
    }

    public int top(){
        return normal.peek();
    }

    public int getMin(){
        return min.peek();
    }

}