/**
 * @ClassName: Selection
 * @Description: TODO
 * @Author: Mr.Ye
 * @Data: 2018-11-19 16:33
 * @Version: 1.0
 **/
public class Selection {
    public static void sort(int[] a) {
        // 升序排列
        int len = a.length; // 数组长度
        for (int i = 0; i < len; i++) {
            int min = i; // 最小元素的索引
            for (int j = i + 1; j < len; j++) {
                if (compare(a[j], a[min])){
                    min = j;
                }
            }
            Swap(a, i, min); // 交换
        }
    }

    private static boolean compare(int v, int w) {
        if (v <= w)
            return true;
        else
            return false;
    }

    private static void Swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1,4,6,3,4,8,9,7,2,5,0};
        System.out.print("初始输出：");
        show(a);
        System.out.println("------------------------------");
        sort(a); // 排序

        System.out.print("最终输出：");
        show(a);
    }
}
