/**
 * @ClassName: Insertion
 * @Description: TODO
 * @Author: Mr.Ye
 * @Data: 2018-11-19 16:42
 * @Version: 1.0
 *
 * 思路：
 * 把整个数组分为两部分，有序和无序。每一次用无序的第一个和有序序列相比较，最后交换。
 **/
public class Insertion {
    // 排序代码
    public static void sort(int[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++){
            for (int j = i; j > 0 && compare(a[j], a[j-1]); j--){
                Swap(a, j, j-1);
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

    // 交换
    private static void Swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // 输出
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {3,1,5,2,7,4,5,9,8,6};
        System.out.print("初始输出：");
        show(a);
        System.out.println("------------------------------");
        sort(a);
        System.out.print("最终输出：");
        show(a);
    }
}

