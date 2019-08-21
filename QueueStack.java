import java.util.LinkedList;
import java.util.Queue;

//�ö���ʵ��ջ
public class QueueStack {
    //jilu��ǰ���еĵ�Ԫ�ظ���
    int size;

    Queue<Integer> queue = new LinkedList<>();

    public void push(int x){
        size++;
        queue.add(x);
    }

    public int pop(){
        //�Ȱ�ǰsize-1 ������  ���������
        for(int i = 0; i < queue.size() - 1; i++ ){

            queue.add( queue.poll());
        }
        size++;
        //����ջ����Ԫ�س�ջ
        return queue.poll();
    }

    public int top(){
        //�Ȱ�ǰsize-1 ������  ���������
        for(int i = 1; i <= queue.size() - 1; i++ ){
            queue.add(queue.poll());
        }
        //��¼��ջ����Ԫ�� �ٽ�Ԫ�س��������
        int v =queue.element();
        queue.add(queue.poll());

        return v;
    }

    public boolean empty(){
        return queue.isEmpty();
    }

}