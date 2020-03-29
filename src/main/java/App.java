/**
 * @author yuan
 * @date 2020/3/29 10:56 上午
 */
public class App {
    public static void main(String[] args) {

        int[] arr = {4,1,2,1,2};
        System.out.println(onlyOne(arr));
    }

    public static int onlyOne(int[] arr) {
        int res = 0;
        for (int i : arr) {
            res ^= i;
        }
        return res;
    }
    //public static int onlyOne2(int[] arr) {
    //    int[] arr =
    //}
}
