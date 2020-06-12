/**
 * @author bo li
 * @date 2020-06-08 16:21
 */
public class Math {

    public static int initData = 666;
    public static User user = new User();

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
        System.out.println("test");
    }

    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }
}
