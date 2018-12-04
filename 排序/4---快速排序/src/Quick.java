/**
 * @ClassName: Quick
 * @Description: TODO
 * @Author: Mr.Ye
 * @Data: 2018-11-21 14:05
 * @Version: 1.0
 *
 * 思路：
 * 找一个基准值，然后从前往后找，找比基准值大的值，从后往前找，找比基准值小的值。
 * 然后交换两个值。
 **/
public class Quick {
    // 排序代码
    //--------------------------------------------------------
    public static void sort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    public static void quicksort(int[] array, int start, int end) {
        if (start < end) {
            int index = partition(array, start, end);
            quicksort(array, start, index - 1);
            quicksort(array, index + 1, end);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int begin = left;
        int end = right;
        int mid = GetMidIndex(array, left, right); // 基准值
        int key; // 设置基准值
        Swap(array, mid, end); // 交换基准值到最右边（end的位置）
        key = array[end];
        while (begin < end) {
            // 从前往后找比基准值大的值
            while (begin < end && array[begin] <= key) {
                begin++;
            }
            // 从后往前找比基准值小的值
            while (begin < end && array[end] >= key) {
                end--;
            }
            // 交换
            if (begin < end)
                Swap(array, begin, end);
        }
        // 把基准值放在中间
        if (begin != right)
            Swap(array, begin, right);

        return begin;
    }

    // 取得一个不大不小的值作为哨兵
    private static int GetMidIndex(int[] arr, int left, int right) {
        int mid = left + ((right - left) >> 1);

        if (arr[left] < arr[right]) {
            if (arr[mid] < arr[left])
                return left;
            if (arr[mid] > arr[right])
                return right;
            else
                return mid;
        } else {
            if (arr[mid] > arr[left])
                return left;
            if (arr[mid] < arr[right])
                return right;
            else
                return mid;
        }
    }

    //--------------------------------------------------------


    // 比较
    private static boolean compare(int v, int w) {
        if (v <= w)
            return true;
        else
            return false;
    }

    // 交换
    private static void Swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    // 输出
    private static void show(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 9, 7, 4, 6, 8, 20, 17, 25, 21};
        System.out.print("初始输出：");
        show(array);
        System.out.println("------------------------------");
        sort(array);
        System.out.print("最终输出：");
        show(array);
    }
}
