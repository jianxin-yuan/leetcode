package search;

/**
 * @author yuan
 * @date 2020/3/6 2:45 下午
 */
public class 基本查询算法 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 12, 15, 20, 22, 22, 23, 44, 55, 111, 878};
        int value = 23;
        System.out.println("index = " + binarySearch(arr, value));
    }


    /**
     * 二分查找: 前提是数组有序.
     * 将目标值与数组中间值比较,若大于, 则表示需要在mid-end区间继续查询,若小于,则在min-mid区间查询
     * 不断循环.直到 left > right 表示查找结束
     *
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch(int[] arr, int value) {

        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            //mid = (left + right) / 2;
            // 关于mid 的计算改进,当left,right比较大时.left+right可能发生整数溢出
            mid = left + (right - left) / 2;
            System.out.println(mid);
            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
