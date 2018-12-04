/**
 * @ClassName: MergeII
 * @Description: TODO
 * @Author: Mr.Ye
 * @Data: 2018-11-21 13:55
 * @Version: 2.0
 *
 * 思路：
 * 先原地两个两个比较，
 * 然后四个四个比较,依次下去
 * 最终会比较完成整个数组
 *
 **/
public class MergeII {
    private static int[] temp; // 临时数组

    //---------------------------------------------------------------------
    // 方法2：  自底向上归并
    public static void sort2(int[] array) {
        int len = array.length;
        temp = new int[len];
        for (int sz = 1; sz < len; sz += sz) {
            for (int le = 0; le < len - sz; le += sz+sz) {
                // 保证最有右边的指针不能越界，所以如果越界了，直接输入的是最后一个元素的下标
//                int sum = 0;
//                if ((le + sz + sz - 1) < (len - 1))
//                    sum = le + sz + sz - 1;
//                else
//                    sum = len - 1;
//
//                merge(array, le, le + sz - 1, sum);

                merge(array, le, le + sz - 1, Math.min(le + sz + sz - 1, len - 1));
            }
        }
    }
//---------------------------------------------------------------------

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

        sort2(array); // 方法2
        System.out.print("最终输出：");
        show(array);
    }
}