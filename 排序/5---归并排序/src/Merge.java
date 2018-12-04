/**
 * @ClassName: Merge
 * @Description: TODO
 * @Author: Mr.Ye
 * @Data: 2018-11-20 13:16
 **/
public class Merge {
    private static int[] temp; // 临时数组

    // 排序代码
    // 方法1：  自顶向下归并
    public static void sort1(int[] array) {
        temp = new int[array.length]; // 给临时数组分配空间
        _sort(array, 0, array.length - 1);
    }

    private static void _sort(int[] array, int left, int right) {
        // 将数组array[left，right]排序
        if (left >= right) {
            return;
        }
        int mid = left + (right - left)/2;

        _sort(array, left, mid); // 左边排序
        _sort(array, mid + 1, right); // 右边排序
        merge(array, left, mid, right); // 归并结果
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int left1 = start, left2 = mid + 1;

        for (int i = start; i <= end; i++) {
            temp[i] = array[i]; // 将数组中内容拷贝到临时数组中
        }

        for (int i = start; i <= end; i++) {
            // 左半边用尽，取右半边的元素
            if (left1 > mid) {
                array[i] = temp[left2++];
            }
            // 右半边用尽，取左半边的元素
            else if (left2 > end) {
                array[i] = temp[left1++];
            }
            // 取左右两边中较小的元素
            else if (compare(temp[left2], temp[left1])) {
                array[i] = temp[left2++];
            } else {
                array[i] = temp[left1++];
            }
        }
    }

    // 比较
    private static boolean compare(int v, int w) {
        if (v <= w)
            return true;
        else
            return false;
    }

    // 输出
    private static void show(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 0, 2, 4, 6, 8};
        System.out.print("初始输出：");
        show(array);
        System.out.println("------------------------------");

        sort1(array); // 方法1
        System.out.print("最终输出：");
        show(array);
    }
}

