import java.util.Arrays;

public class Heaps {
    /**
     * ǰ�᣺����index�����ĺ����⣬����λ��������ѵ�����
     * <p>
     * �������µ��������ճ�Ϊһ����
     *
     * @param array �������ѵ�����
     * @param size  �����б������ѵ�ֵ�ĸ���
     * @param index Ҫ����λ�õ��±�
     */
 //���µ���
    public static void heapify(int[] array, int size, int index) {
        while (true) {
            int left = 2 * index + 1;
            if (left >= size) { return; }
            int max = left;
            if (left + 1 < size) {
                if (array[left + 1] > array[left]) {
                    max = left + 1;
                }
            }
            if (array[index] >= array[max]) { return; }
            swap(array, index, max);
            index = max;
        }
    }
    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

//���ݸ�����һ������  �������
    public static void creatHeap(int[] array, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--){
            heapify(array,size,i);
        }
    }

//���ϵ���
    public static void adjustUp(int[] array, int index) {
        while(index > 0){
            int parent = (index - 1) / 2;
            if (array[index] > array[parent]) {
                swap(array,index,parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { -1, 8, 4, 6, 7, 2, 3, 1, 0 };
        heapify(array, array.length, 0);
        System.out.println(Arrays.toString(array));
        heapify(array, array.length, 0);
        System.out.println(Arrays.toString(array));
        int[] array1 = {3, 5, 2, 4, 9, 0, 1, 9, 8, 4, 7, 2, 3, 8, 6, 3};
        creatHeap(array1,array1.length);
        System.out.println(Arrays.toString(array1));
    }
}