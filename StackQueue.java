import java.util.Stack;

//��ջʵ�ֶ���
//������ջʵ��һ������
public class StackQueue {
    //��������ջ
    //ջ1��Ҫ����Ԫ�����  ջ2��Ҫ����Ԫ�س���
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int x) {
        //������Ԫ�طŽ�1ջ
        stack1.push(x);
    }

    public int pop(){
        //��2ջ��ջ�� ��2ջΪ�� ��1ջ��Ԫ�ط���2ջ �ٴ�2ջ��ջ
        if(stack2.empty()) {
            while(!(stack1.empty())){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek(){
        //������ʾջ2����Ԫ��  ��ջ2Ϊ�� ��ջ1Ԫ���Ƶ�ջ2
        if(stack2.empty()) {
            while(!(stack1.empty())){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty(){
        return stack1.empty() && stack2.empty();
    }
}
