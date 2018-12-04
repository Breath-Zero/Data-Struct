/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: Mr.Ye
 * @Data: 2018-11-19 16:05
 * @Version: 1.0
 **/
public class Test {
    // 排序代码
    public static void sort(int[] array) {

    }

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
        // 调用方法
        System.out.print("初始输出：");
        // 1、调用show()方法
        System.out.println("------------------------------");
        // 2、调用sort(a)方法
        System.out.print("最终输出：");
        // 3、调用show(a)方法

        int[] array = {1,3,5,7,9,0,2,4,6,8};
        System.out.print("初始输出：");
        show(array);
        System.out.println("------------------------------");
        sort(array);
        System.out.print("最终输出：");
        show(array);
    }
}