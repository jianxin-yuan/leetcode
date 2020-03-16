package practice;

/**
 * @author yuan
 * @date 2020/3/13 8:44 下午
 * <p>
 * 泛型应用考察
 */
public class Practice {

    public static void main(String[] args) {
        int minInteger = min(new Integer[]{1, 2, 3});//result:1
        System.out.println(minInteger);
        double minDouble = min(new Double[]{1.2, 2.2, -1d});//result:-1d
        System.out.println(minDouble);
        //String typeError = min(new String[]{"1","3"});//报错
    }

    //自己设计一个泛型的获取数组最小值的函数.并且这个方法只能接受Number的子类并且实现了Comparable接口
    public static <N extends Number & Comparable<? super N>> N min(N[] arr) {
        N min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min.compareTo(arr[i]) > 0) {
                min = arr[i];
            }
        }
        return min;
    }

}
