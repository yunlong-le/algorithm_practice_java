package basic.class01;

/**
 * @author wangt
 * @create 2023/10/9 18:48
 */
public class Code06_BSAwesome {
    //局部最小值问题
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        if (arr.length == 1 || arr[0] < arr[1]) return 0;
        if (arr[arr.length - 2] > arr[arr.length - 1]) return arr.length - 1;
        int l = 1;
        int r = arr.length - 2;
        while (l < r) {
            int mid = l + ((r - l) >> 2);
            if (arr[mid] > arr[mid - 1]) {
                r = mid - 1;
            } else if (arr[mid + 1] < arr[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }
}
