public class InsertSort{
public static void insertSortV1(int[] array) {
        for (int i = 0; i < array.length - 1; i++){
            //��������   [0,i]
            // ��������		[i + 1, array.length)
            // ������������� array[i + 1]
            // ������������������ڲ���

            int key = array[i + 1];
            int j;
            for (j = i; j >= 0; j--) {
                if(key >= array[j]) {
                    break;
                }
            }
            //j + 1 ��key��λ��
            for (int k = i;k > j; k--) {
                array[k + 1] = array[k];
            }
            array[j + 1] = key;
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int key = array[i + 1];
            int j;
            for(j = i; j >= 0 && key < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }
}