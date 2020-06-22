package search;

/**
 * @author yuan
 * @date 2020/3/19 10:52
 * <p>
 * https://leetcode-cn.com/problems/first-bad-version/
 */
public class FirstBadVersion {

    public boolean isBadVersion(int n) {
        return false;
    }

    //二分查找思想
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
