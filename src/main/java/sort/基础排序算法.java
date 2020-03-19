package sort;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/3/5 5:22 下午
 * 基础排序算法
 */
public class 基础排序算法 {
    public static void main(String[] args) {

        int[] arr = {0, 100, 3, 2, 4, 6, 1, 7, 5, 8, 11, 33, 22, 22};

        //bubbleSort(arr);
        //selectionSort(arr);
        //insertionSort(arr);
        //shellSort(arr);
        //mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * ref : https://mp.weixin.qq.com/s?__biz=Mzg2NzA4MTkxNQ==&mid=2247485191&amp;idx=1&amp;sn=45a43bd77495566db53b419ae82136f5&source=41#wechat_redirect
     * 快速排序: 类似归并排序思想,首先选取一个基准数,将小于基准数的移动到左边,大于基准数的移动到右边,此时,基准数在数组中就是处于正确的排序位置,
     * 然后再分别对左右2个小数组进行同样的处理.直到每个数组都只有一个数时,表示排序完成
     *
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        //选取基准数,将数组分为左右2个小数组
        int pivot = arr[left];
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }

            while (i <= j && arr[j] >= pivot) {
                j--;
            }

            if (i >= j) {
                break;
            }

            //交换i和j对应元素
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        //交换基准数与j位置的元素,此时,基准数排序完成
        arr[left] = arr[j];
        arr[j] = pivot;


        //对左边的数组进行快速排序
        quickSort(arr, left, j - 1);
        //对右边的数组进行快速排序
        quickSort(arr, j + 1, right);
    }


    /**
     * 归并排序: 将一个大的数组不断分为小数组,直到每个小数组都只有一个元素.此时所有的小数组都是有序的(单个元素有序)
     * 此时,只需要将所有的小数组中最小的元素不断与其他数组最小值比较,然后放入一个辅助数组中,当所有数组处理完后.
     * 辅助数组中的数据就是排序完成的数据了.
     *
     * @param arr
     * @param left  左边界
     * @param right 有边界
     * @param temp  临时数组,调用时创建一个,避免递归里重复创建
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //左边数组排序
            mergeSort(arr, left, mid, temp);
            //右边数组排序
            mergeSort(arr, mid + 1, right, temp);
            //合并2个数组
            merge(arr, left, mid, right, temp);
        }
    }

    // 将arr[left...mid]与arr[mid+1...right]合并为一个有序数组
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // int[] temp = new int[right-left + 1 ];
        int i = left; // 左数组指针
        int j = mid + 1; // 右数组指针
        int k = 0; // 临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 判断如果左边数组没有加完.将其全部加入临时数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 判断如果右边数组没有加完.将其全部加入临时数组
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 临时数组指针置0,将临时数组内容复制到原始数组中left...right位置上
        k = 0;
        while (left <= right) {
            arr[left++] = temp[k++];
        }

    }

    /**
     * 希尔排序:   是对插入排序的一种优化,通过将数组按间隔分为几个组,对每个组进行插入排序,
     * 调整整个数组的大体顺序,然后逐渐减小间隔,重复进行插入排序,当间隔为1时,进行最后一次插入排序
     * 此时,数组基本是有序的,可以减少插入排序的移动量
     *
     * @param arr
     * @return
     */
    public static void shellSort(int[] arr) {
        // 每次gap变为一半
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j;
                int temp = arr[i]; // 临时变量存储待插入数据
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j]; // 当前数比需要插入的数大,将其复制到待插入数位置
                }
                arr[j + gap] = temp; // 找到了待插入数据真正的位置
            }
        }

    }


    /**
     * 插入排序: 从第二个元素开始,与前面的数进行比较,如果小,则交换位置,否则继续往前,直到找到它的位置,依次循环.
     * <p>
     * * 2,4,1,5,7 --> i=1,j=0,temp=4,arr[0]=2,--> arr[1] = 4 --> 2,4,1,5,7
     * * 2,4,1,5,7 --> i=2,j=1,temp=1,arr[1]=4 --> arr[2]=4 --> 2,4,4,5,7
     * * --> i=2,j=0,temp=1,arr[0]=2 --> arr[1]=2 --> 2,2,4,5,7
     * * --> i=2,j=-1,temp=1 --> arr[0]=1 --> 1,2,4,5,7
     *
     * @param arr
     * @return
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j;
            int temp = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }

    }

    /**
     * 选择排序: 先找到最小的数,放到首位,然后在剩余数据中找最小的数,放到第二位,以此类推.
     *
     * @param arr
     * @return
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 找到本次循环中最小值的index
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            // 交换本次循环中最小值与初始循环位置的值
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }


    /**
     * 冒泡排序: 每次比较相邻2个数.大的放后面.进过一轮排序后,最大的数落到最后.进过几轮后,没有可交换的表示数据处理完成
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            // 每经过一次排序,会有至少一个元素排好序,所有可以少循环一次.
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }

            // 如果标志位没有改变.说明已经排序完成
            if (flag) {
                break;
            }
        }
    }
}
