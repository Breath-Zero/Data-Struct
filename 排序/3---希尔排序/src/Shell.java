/**
 * @ClassName: Shell
 * @Description: TODO
 * @Author: Mr.Ye
 * @Data: 2018-11-19 17:22
 * @Version: 1.0
 **/
public class Shell { // 排序代码
    // 方法1

//    public static void sort(int[] a) {
//        int len = a.length;
//        int gap = len;
//        while (gap > 1){
//            gap = gap/3 + 1;
//            for (int i = gap; i < len; i++){
//                int key = a[i];
//                int end = i - gap;
//                while (end >= 0 && key < a[end]){
//                    a[end+gap] = a[end];
//                    end -= gap;
//                }
//                a[end+gap] = key;
//            }
//        }
//    }

    // 方法2

    public static void sort(int[] a) {
        int len = a.length;
        int gap = 1;
        while (gap < len / 3) {
            gap = 3 * gap + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                for (int j = i; j >= gap && compare(a[j], a[j - gap]); j -= gap) {
                    Swap(a, j, j - gap);
                }
            }
            // 结束上次循环后让 间隔 除以3，直到间隔等于1
            gap = gap / 3;
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
        int[] a = {5, 2, 7, 4, 8, 1, 9, 0, 6, 3};
        System.out.print("初始输出：");
        show(a);
        System.out.println("------------------------------");
        sort(a);
        System.out.print("最终输出：");
        show(a);
    }
}
