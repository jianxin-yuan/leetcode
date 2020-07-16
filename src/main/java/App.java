/**
 * @author yuan
 * @date 2020/3/29 10:56 上午
 */
public class App {


    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(quickSearch(arr, 0, arr.length - 1, arr.length / 2));
    }

    public static int quickSearch(int[] arr, int left, int right, int index) {
        if (left >= right) {
            return arr[left];
        }

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
            swap(arr, i, j);
        }

        arr[left] = arr[j];
        arr[j] = pivot;


        if (j == index) {
            return arr[j];
        }

        return j > index ? quickSearch(arr, left, j - 1, index) : quickSearch(arr, j + 1, right, index);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
