public class MyCircularQueue {
    private int[] array;
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    public MyCircularQueue(int k) {
        array = new int[k];
    }

    //���
    public boolean enQueue (int value) {
        if (array.length == size) {
            return false;
        }

        array[rear] = value;
        rear = (rear + 1) % array.length;
        size ++;
        return true;
    }

    //����
    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        front = (front + 1) % array.length;
        size --;
        return true;
    }

    //���ض���
    public int Front() {
        if(size == 0) {
            return -1;
        }
        return array[front];
    }

    //���ض�β
    public int Rear() {
        if(size == 0) {
            return -1;
        }
        int index = (rear - 1 + array.length) % array.length;
        return array[index];
    }

    //�ж϶ӿ�
    public boolean isEmpty() {
        return size == 0;
    }

    //�ж϶���
    public boolean isFull() {
        return size == array.length;
    }
}
