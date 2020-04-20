package sort;

/**
 * @author yuan
 * @date 2020/3/30 9:12 下午
 * <p>
 * https://mp.weixin.qq.com/s?__biz=Mzg2NzA4MTkxNQ==&mid=2247485231&amp;idx=1&amp;sn=8dfdc04bd209fba3077269faabe7c36f&source=41#wechat_redirect
 * <p>
 * 二叉堆: 一般分为最小堆(左右节点都比根节点大)和最大堆(左右节点都比根节点小)
 * 根据完全二叉树的特点，假如一个节点的下标为n,则可以求得它左孩子的下标为：2n+1；右孩子下标为：2n+2。
 * <p>
 * <p>
 * 本例以最小堆为例
 */
public class BinaryHeap {

    /**
     * 上浮操作，将元素加入最后一个位置,然后进行上浮操作调整二叉堆
     *
     * @param arr
     * @param length 二叉堆的长度
     */
    public static int[] upAdjust(int[] arr, int length) {
        int child = length - 1;
        int parent = (child - 1) / 2;
        int temp = arr[child];
        while (child > 0 && arr[parent] > temp) {
            //单向赋值就行,当找到child正确位置后把temp值赋给它就行
            arr[child] = arr[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        arr[child] = temp;
        return arr;
    }

    /**
     * 下沉操作,删除root节点,将最后一个元素提到root,然后进行下沉调整二叉堆
     *
     * @param arr
     * @param parent 要下沉元素的下标
     * @param length
     */
    public static int[] downAdjust(int[] arr, int parent, int length) {
        int temp = arr[parent];
        int child = parent * 2 + 1;
        while (child < length) {
            //如果右孩子节点比左孩子小，则定位到右孩子
            if (child + 1 < length && arr[child] > arr[child + 1]) {
                child++;
            }

            if (temp <= arr[child]) {
                break;
            }

            //交换
            arr[parent] = arr[child];
            parent = child;
            child = parent * 2 + 1;
        }
        arr[parent] = temp;
        return arr;
    }


    /**
     * 根据数组构建一个二叉堆,相当于一个一个插入元素,然后进行上浮操作
     *
     * @param arr
     * @param length
     * @return
     */
    public static int[] buildBinaryHeap(int[] arr, int length) {
        //从最后一个非叶子节点开始下沉
        for (int i = (length - 2) / 2; i >= 0; i--) {
            arr = downAdjust(arr, i, length);
        }
        return arr;
    }
}
