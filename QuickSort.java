public class QuickSort {
    public static void quickSort(int[] array) {
        quickSort1(array, 0, array.length - 1);
    }

    private static void quickSort1(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        //1.ȷ����׼ֵarray[right] ��Ϊ��׼ֵ
        //2.����  С����  �����
        int pivotIndex = partition(array, left, right);
        //�ֳ�����С����[left, pivotIdex] [pivotIndex + 1, right]
        //3.��
        quickSort1(array,left,pivotIndex - 1);
        quickSort1(array,pivotIndex + 1, right);
    }

    //�һ�׼ֵ�����ַ���
    private static int partition1(int[] array, int left, int right) {
        int pivot = array[right];
        int less = left;
        int great = right;
        while(less < great) {
            while (less < great && array[less] <= pivot) {
                less++;
            }
            while (less < great && array[great] >= pivot) {
                great--;
            }
        }
        return less;
    }
    private static int partition2(int[] array,int left,int right) {
        //���
        int pivot = array[right];
        int less = left;
        int great = right;
        while(less < great) {
            while (less < great && array[less] <= pivot) {
                less++;
            }
            array[great] = array[less];
            while (less < great && array[great] >= pivot) {
                great--;
            }
            array[less] = array[great];
        }
        array[less] = pivot;
        return less;
    }
    private static int partition3(int[] array, int left, int right) {
        int less = left;
        int pivot = array[right];
        for(int i = left; i < right; i++) {
            if (array[i] < pivot){
                swap(array,less,i);
                less++;
            }
        }
        swap(array,less,right);
        return less;
    }
    private static int[] partition4(int[] array, int left, int right) {
        int pivot = array[right];
        int less = left;
        int great = right;
        int i = left;

        while (i < great) {
            if (array[i] == pivot) { i++; } 
            else if (array[i] < pivot) {
                swap(array, i, less);
                i++;
                less++;
            } else {
                while (i < great && array[great] > pivot) { great--; }
                swap(array, i, great);
            }
        }
        return new int[] {less, great - 1};
    }

    
    private static void swap(int[] array, int j, int i) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
