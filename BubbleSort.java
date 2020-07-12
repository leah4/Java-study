class BubbleSort{
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i ++) {
            //范围[0, array.length - i]
            boolean sorted = true;
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    sorted = false;
                }
            }
            //已经有序 即没有进行交换 可直接跳出
            if (sorted) {
                break ;
            }
        }
  }
  private static void swap(int[] array, int j, int i) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
   }
    
    //冒泡排序的基本实现
    public static void bubbleSortNormal(int[] array){
        int i,j;
        for(i=0;i<array.length-1;i++)
        {
            for(j=0;j<array.length-1-i;j++)
            {
                if(array[j]>array[j+1])
                {
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
}
