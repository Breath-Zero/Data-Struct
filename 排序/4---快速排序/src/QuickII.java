/**
 * @ClassName: QuickII
 * @Description: TODO
 * @Author: Mr.Ye
 * @Data: 2018-11-21 14:47
 * @Version: 1.0
 *
 * 思路：
 * 找一个基准值，然后从前往后找，找比基准值大的值，然后和最后一个元素交换，
 * 从后往前找，找比基准值小的元素，然后和之前的坑（begin）交换。一直如此，直到begin和end相遇
 **/

// 挖坑法
public class QuickII {
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
    // 挖坑法
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
                begin++; // 当遇到比key大的值就停下来
            }
            // 如果找到后，begin小于end，让begin去填补之前的标志位，也就是end
            if (begin < end){
                array[end] = array[begin];
                end--;
            }
            // 从后往前找比基准值小的值
            while (begin < end && array[end] >= key) {
                end--; // 当遇到比key小的值就停下来
            }
            // 如果找到后，begin小于end，让end去填补之前的标志位，也就是begin
            if (begin < end){
                array[begin] = array[end]; // 填补完让begin++，此时坑又在end的位置
                begin++;
            }
        }
        // 如果begin和end的相遇位置不是基准值的位置，把begin和基准值交换
        // 出了循环代表begin和end相遇，然后让基准值去填最后一个坑（也就是相遇点）
        array[begin] = key;

        return begin;
    }

    // 取得一个不大不小的值作为哨兵
    private static int GetMidIndex(int[] arr, int left, int right) {
        int mid = left + ((right - left) >> 1); // 取得中间值

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
