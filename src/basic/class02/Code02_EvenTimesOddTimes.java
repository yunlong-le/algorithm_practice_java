package basic.class02;

import java.util.Arrays;

/**
 * @author wangt
 * @create 2023/10/9 19:21
 */
public class Code02_EvenTimesOddTimes {
    // arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int j : arr) {
            eor ^= j;
        }
        System.out.println(eor);
    }

    // arr中，有两种数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int i : arr) {
            if ((rightOne & i) == 0) {
                onlyOne ^= i;
            }
        }
        System.out.println(onlyOne + " " + (onlyOne ^ eor));
    }

    public static int bit1counts(int N) {
        int count = 0;

        //   011011010000
        //   000000010000     1

        //   011011000000
        //


        while (N != 0) {
            int rightOne = N & ((~N) + 1);
            count++;
            N ^= rightOne;
            // N -= rightOne
        }


        return count;

    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        Arrays.sort(arr1);
        printArray(arr1);
        printOddTimesNum1(arr1);

        int[] arr2 = {4, 14, 4, 10, 10, 10, 4, 1, 1, 1, 14, 14, 1, 1, 1, 4, 10, 10};
        Arrays.sort(arr2);
        printArray(arr2);
        printOddTimesNum2(arr2);

    }
}
