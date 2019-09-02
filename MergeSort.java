import java.util.Arrays;

public class MergeSort {
    public static void mergeSort (int[] array) {
        //�������д��±�Ϊ0λ�õ��±����λ�������ڿ�ʼ����
       mergeSort1(array, 0, array.length);
    }

    private static void mergeSort1(int[] array, int low, int high) {
        //���䳤��С�ڵ���1�Ϳ�ֹͣ����
        int length = high - low;
        if (length <= 1) {
            return;
        }
        //��������м�ֳ�����С����
        //�ֱ������С������й鲢
        int mid = (low + high) / 2;
        mergeSort1(array, low, mid);
        mergeSort1(array, mid, high);
        merge(array, low, mid, high);
    }

    //�����źõ�����ϲ�����
    private static void merge(int[] array, int low, int mid, int high) {
        int length = high - low;
        int[] extra = new int[length];

        //�������������ñ����������ź�������� �����бȽ� ��˳������µ�������
        int left = low;
        int right = mid;
        int extraLength =0;

        while(left < mid && right < high){
            if (array[left] <= array[right]) {
                extra[extraLength++] = array[left++];
            } else {
                extra[extraLength++] = array[right++];
            }
        }
        //һ�����ź������Ѿ�ȫ���������������һ����û�д���
        // ����������Ԫ��ȫ������������ ����ʱ˳��һ�������źõ�
        while (left < mid) {
            extra[extraLength++] = array[left++];
        }
        while(right < high) {
            extra[extraLength++] = array[right++];
        }
        //��Ԫ�ذ��ƻ�ԭ����
        for(int i = 0; i < length; i++){
            array[low + i] = extra[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 5, 1, 4, 8, 3, 7, 15, 6, 14, 9};
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}